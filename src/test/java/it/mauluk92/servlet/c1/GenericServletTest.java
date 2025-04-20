package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;

/**
 * This class contains tests to validate rules about
 * {@link GenericServlet} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class GenericServletTest {

    @Mock
    private GenericServlet genericServlet;


    /**
     * Did you notice that you had to provide implementations for all the methods in
     * the {@link Servlet} interface even though some of them did not contain code?
     * In addition, you needed to preserve the {@link ServletConfig} object into a class
     * level variable.
     * Fortunately, the {@link GenericServlet} abstract class comes to the rescue.
     * In keeping the spirit of easier code writing in object-oriented programming.
     * {@link GenericServlet} implements both {@link Servlet} and the {@link ServletConfig}
     * and perform the following tasks:
     * <ul>
     *     <li>
     *         Assign the {@link ServletConfig} in the {@code init} method to a class level
     *         variable so that it can be retrieved by calling {@code getServletConfig}.
     *     </li>
     *     <li>
     *         Provide default implementations of all methods in the {@link Servlet} interface.
     *     </li>
     *     <li>
     *         Provide methods that wrap the methods in the {@link ServletConfig}
     *     </li>
     * </ul>
     * {@link GenericServlet} preserves the {@link ServletConfig} object by assigning it to
     * a class level variable {@code servletConfig} in the {@link GenericServlet}.
     * However, if you override this method in yopur class, the {@code init} method in your servlet will be
     * called instead, and you have to call {@code super.ini(servletConfig)} to preserve the {@link ServletConfig}.
     * To save you from having to do so, {@link GenericServlet} provide a second {@code init} method, which
     * does not take any arguments. This method is called by the first {@code init} method after
     * {@link ServletConfig} is assigned to a class level variable. This means you can write initialization code by overriding
     * the no argument {@code init} method and the {@link ServletConfig} will still be preserved by the {@link GenericServlet}
     * instance.
     */
    @Test
    @DisplayName("GenericServlet class")
    public void genericServletClass(){
        Assertions.assertInstanceOf(GenericServlet.class, genericServlet);
    }
}
