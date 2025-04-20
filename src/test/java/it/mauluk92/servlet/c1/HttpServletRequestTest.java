package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This class contains tests to validate rules about
 * {@link HttpServletRequest} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class HttpServletRequestTest {

    private final static String CONTEXT_PATH = "/context";
    private final static String HEADER_NAME = "NAME";
    private final static String HEADER_VALUE = "VALUE";
    private final static String METHOD = "GET";
    private final static String QUERY_STRING = "QUERY";

    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private Cookie cookie;
    @Mock
    private HttpSession httpSession;

    @BeforeEach
    public void setup(){
        Mockito.when(httpServletRequest.getMethod()).thenReturn(METHOD);
        Mockito.when(httpServletRequest.getContextPath()).thenReturn(CONTEXT_PATH);
        Mockito.when(httpServletRequest.getCookies()).thenReturn(new Cookie[]{cookie});
        Mockito.when(httpServletRequest.getHeader(HEADER_NAME)).thenReturn(HEADER_VALUE);
        Mockito.when(httpServletRequest.getSession()).thenReturn(httpSession);
        Mockito.when(httpServletRequest.getQueryString()).thenReturn(QUERY_STRING);
    }

    /**
     * {@link HttpServletRequest} represents the servlet request in the HTTP environment.
     * It extends the {@link ServletRequest} interface and adds several methods. Some of the
     * methods added are as follows: {@code getContextPath}, which returns the portion of the request URI that indicates
     * the context of the request. {@code getCookies} which returns an array of {@link Cookie} objects.
     * The {@code getHeader} which returns the value of the specified HTTP header.
     * The {@code getMethod} which returns the method HTTP.
     * The {@code getQueryString} which returns the query string in the request URI.
     * The {@code getSession} which returns the session object, with an optional flag which creates
     * a session object if none has been found.
     */
    @Test
    @DisplayName("HttpServletRequest interface methods")
    public void httpServletRequestMethods(){
        Assertions.assertEquals(CONTEXT_PATH, httpServletRequest.getContextPath());
        Assertions.assertEquals(cookie, httpServletRequest.getCookies()[0]);
        Assertions.assertEquals(HEADER_VALUE, httpServletRequest.getHeader(HEADER_NAME));
        Assertions.assertEquals(METHOD, httpServletRequest.getMethod());
        Assertions.assertEquals(QUERY_STRING, httpServletRequest.getQueryString());
        Assertions.assertEquals(httpSession, httpServletRequest.getSession());
    }
}
