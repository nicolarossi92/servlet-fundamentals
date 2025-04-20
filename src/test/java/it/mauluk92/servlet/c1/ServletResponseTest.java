package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This class contains tests to validate rules about
 * {@link ServletResponse} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ServletResponseTest {

    private final static String CONTENT_TYPE = "text/html";

    @Mock
    private ServletResponse servletResponse;
    @Mock
    private PrintWriter printWriter;

    @BeforeEach
    public void setup() throws IOException {
        Mockito.when(servletResponse.getContentType()).thenReturn(CONTENT_TYPE);
        Mockito.when(servletResponse.getWriter()).thenReturn(printWriter);
        Mockito.doAnswer(invocation -> {
            String message = invocation.getArgument(0);
            System.out.println(message);
            return null;
        }).when(printWriter).write(Mockito.anyString());
    }

    /**
     * The {@link ServletResponse} interface represents a servlet response. Prior to
     * invoking a servlet's {@code service} method, the servlet container
     * creates a {@link ServletResponse} and pass it as the second argument to the {@code service} method.
     * The {@link ServletResponse} hides the complexity of sending response to the browser.
     * One of the methods defined in {@link ServletResponse} is the {@code getWriter} method,
     * which returns a {@link PrintWriter} that can send text to the client.
     * When sending a response to the client, most of the time you send it as HTML. Before sending any HTML
     * tag, you should set the content type of the response by calling the {@code setContentType} method, passing
     * "text/html" as an argument
     */
    @Test
    @DisplayName("ServletResponse interface methods")
    public void servletResponseMethods() throws IOException {
        // Setting content type for Content Type

        servletResponse.setContentType(CONTENT_TYPE);

        // Getting content type for Content Type

        Assertions.assertEquals(CONTENT_TYPE, servletResponse.getContentType());

        // Getting PrintWriter from response

        PrintWriter writer = servletResponse.getWriter();

        // Writing to output

        writer.write("Hello World! From Response");
    }
}
