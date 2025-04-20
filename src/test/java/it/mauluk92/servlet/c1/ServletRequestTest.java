package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletRequest;

/**
 * This class contains tests to validate rules about
 * {@link ServletRequest} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ServletRequestTest {

    private final static int CONTENT_LENGTH = 7;
    private final static String MIME_TYPE = "text/html";
    private final static String PARAMETER_VALUE = "ParameterValue";
    private final static String PROTOCOL_NAME = "ProtocolName";

    @Mock
    private ServletRequest servletRequest;

    @BeforeEach
    public void setup() {
        Mockito.when(servletRequest.getContentLength()).thenReturn(CONTENT_LENGTH);
        Mockito.when(servletRequest.getContentType()).thenReturn(MIME_TYPE);
        Mockito.when(servletRequest.getParameter(Mockito.anyString())).thenReturn(PARAMETER_VALUE);
        Mockito.when(servletRequest.getProtocol()).thenReturn(PROTOCOL_NAME);
    }

    /**
     * For every request, the servlet container creates an instance of
     * {@link ServletRequest} and passes it to the servlet {@code service} method.
     * The {@link ServletRequest} encapsulates information about the request. These
     * are some of the method in the {@link ServletRequest} interface:
     * <ul>
     *     <li>
     *         {@code getContentLength()}: returns the number of bytes in the request body: if length is
     *         not known, the method returns -1
     *     </li>
     *     <li>
     *         {@code getContentType()}: returns the MIME type of the request body or null
     *         if the type is not known
     *     </li>
     *     <li>
     *         {@code getParameter(String name)}: returns the value of the specified request parameter
     *     </li>
     *     <li>
     *         {@code getProtocol()}: returns the name and version of the protocol of this HTTP request.
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("ServletRequest interface")
    public void servletRequestInterface() {
        Assertions.assertEquals(CONTENT_LENGTH, servletRequest.getContentLength());
        Assertions.assertEquals(MIME_TYPE, servletRequest.getContentType());
        Assertions.assertEquals(PARAMETER_VALUE, servletRequest.getParameter(""));
        Assertions.assertEquals(PROTOCOL_NAME, servletRequest.getProtocol());
    }
}
