package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class contains tests to validate rules about
 * {@link HttpServletResponse} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class HttpServletResponseTest {

    private final static String HEADER_NAME = "NAME";
    private final static String HEADER_VALUE = "VALUE";
    private final static String LOCATION_REDIRECT = "REDIRECT";

    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    private Cookie cookie;

    @BeforeEach
    public void setup() throws IOException {
        Mockito.doAnswer(invocation -> {
            System.out.println("Added cookie!");
            return null;
        }).when(httpServletResponse).addCookie(Mockito.any());
        Mockito.doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            String value = invocation.getArgument(1);
            System.out.printf("Added header - %s : %s %n", name, value);
            return null;
        }).when(httpServletResponse).addHeader(Mockito.anyString(), Mockito.anyString());
        Mockito.doAnswer(invocation -> {
            String location = invocation.getArgument(0);
            System.out.printf("Redirecting to location: %s%n", location);
            return null;
        }).when(httpServletResponse).sendRedirect(Mockito.anyString());
    }

    /**
     * {@link HttpServletResponse} represents the servlet response in the HTTP
     * environment. Here are some of the methods defined in it:
     * <ul>
     *     <li>
     *         {@code addCookie} which adds a cookie to the response object
     *     </li>
     *     <li>
     *         {@code addHeader} which adds an header to this response object
     *     </li>
     *     <li>
     *         {@code sendRedirect} which sends a response code that redirects the browser to the
     *         specified location
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("HttpServletResponse interface methods")
    public void httpServletResponseMethods() throws IOException {
        httpServletResponse.addCookie(cookie);
        httpServletResponse.addHeader(HEADER_NAME, HEADER_VALUE);
        httpServletResponse.sendRedirect(LOCATION_REDIRECT);
        Assertions.assertInstanceOf(HttpServletResponse.class, httpServletResponse);
    }
}
