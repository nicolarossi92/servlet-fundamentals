package it.mauluk92.servlet.c1;

import it.mauluk92.servlet.c1.utils.MyHttpServlet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class contains tests to validate rules about
 * {@link HttpServlet} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class WritingHttpServletTest {

    private MyHttpServlet httpServlet;
    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletResponse httpServletResponse;

    @BeforeEach
    public void setup(){
        this.httpServlet = new MyHttpServlet();
    }

    /**
     * The {@link HttpServlet} class overrides the {@link GenericServlet} class.
     * When using {@link HttpServlet}, you will also work with {@link HttpServletRequest}
     * and {@link HttpServletResponse} objects that represent the servlet request
     * and the servlet response, respectively. The {@link HttpServletRequest} interface
     * extends {@link ServletRequest} and {@link HttpServletResponse} extends
     * {@link ServletResponse}.
     * {@link HttpServlet} overrides the {@code service} method in {@link GenericServlet}
     * and adds another {@code service} method with the http request, response signatures.
     * The new {@code service} method in {@link HttpServlet} then examines the HTTP method
     * used to send the request (by calling {@code request.getMethod}) and call one of the
     * corresponding method ({@code doGet}, {@code doPut} and so on).
     * To summarize, you override those same method. In rare cases you override other methods.
     */
    @Test
    @DisplayName("HttpServlet interface specific methods")
    public void httpServletMethods() throws ServletException, IOException {

        // Calling GET

        Mockito.when(httpServletRequest.getMethod()).thenReturn("GET");
        httpServlet.service(httpServletRequest, httpServletResponse);

        // Calling POST

        Mockito.when(httpServletRequest.getMethod()).thenReturn("POST");
        httpServlet.service(httpServletRequest, httpServletResponse);

        // Calling PUT

        Mockito.when(httpServletRequest.getMethod()).thenReturn("PUT");
        httpServlet.service(httpServletRequest, httpServletResponse);

        // And so on...
    }
}
