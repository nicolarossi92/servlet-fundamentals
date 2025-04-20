package it.mauluk92.servlet.c1;

import it.mauluk92.servlet.c1.utils.MyServlet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;
import java.io.IOException;

/**
 * Class to illustrates the rules about creating a simple servlet.
 * Also showing Servlet API
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class WritingSimpleServletTest {

    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletRequest servletRequest;
    @Mock
    private ServletResponse servletResponse;

    /**
     * The {@link Servlet} interface defines these five methods:
     * <ol>
     *     <li>
     *         {@code init}: The servlet container invokes this method the first time
     *         the servlet is requested. This method is not called at subsequent requests. You use
     *         this code to write initialization code. When invoking this method, servlet container
     *         passes a {@link ServletConfig}. Normally, you will assign the {@link  ServletConfig}
     *         to a class level variable so that this object can be used from other points in the servlet
     *         class
     *     </li>
     *     <li>
     *         {@code service}: The servlet container invokes this method each time the servlet is requested.
     *         You write the code that the servlet is supposed to do here. The first time the servlet is requested.
     *         The servlet container calls the {@code init} method and. For subsequent requests, only {@code service}
     *         is invoked.
     *     </li>
     *     <li>
     *         {@code destroy}: The servlet container invokes this method when the servlet is about to be destroyed.
     *         This occurs when the application is unloaded or when the servlet container is being shutdown. Normally, you write
     *         clean up code in this method
     *     </li>
     * </ol>
     * The other two method in {@link Servlet} are non lifecycle methods: {@code getServletInfo} and {@code getServletConfig}
     */
    @Test
    @DisplayName("Method in Servlet Interface")
    public void servletInterfaceMethods() throws ServletException, IOException {
        MyServlet servlet = new MyServlet();
        // First, the init method is invoked
        servlet.init(servletConfig);
        // Then, at each request, is invoked service
        servlet.service(servletRequest, servletResponse);
        // When the servlet is being shutdown, destroy is invoked
        servlet.destroy();

        // The other two methods are non-lifecycle methods

        // This get the ServletConfig previously registered by the init method

        Assertions.assertEquals(servletConfig, servlet.getServletConfig());

        // While this one gets information about the servlet

        Assertions.assertEquals("MyServlet", servlet.getServletInfo());

    }
}
