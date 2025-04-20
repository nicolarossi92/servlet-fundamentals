package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;

/**
 * This class contains tests to validate rules about
 * {@link ServletContext} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ServletContextTest {

    private final static String ATTRIBUTE_NAME = "NAME";
    private final static String ATTRIBUTE_VALUE = "VALUE";

    @Mock
    private ServletContext servletContext;

    @BeforeEach
    public void setup(){
        Mockito.doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            String value = invocation.getArgument(1);
            System.out.printf("Setting attribute - %s : %s %n", name, value);
            return null;
        }).when(servletContext).setAttribute(Mockito.anyString(), Mockito.any());

        Mockito.doAnswer(invocation -> {
            String name = invocation.getArgument(0);
            System.out.printf("Removing attribute with name: %s %n", name);
            return null;
        }).when(servletContext).removeAttribute(Mockito.anyString());

        Mockito.when(servletContext.getAttribute(Mockito.any()))
                .thenReturn(ATTRIBUTE_VALUE);
    }

    /**
     * The {@link ServletContext} represents the servlet application. There is only one context
     * per web application. In a distributed environment where an application is deployed
     * simultaneously to multiple containers, there is one {@link ServletContext} object per
     * Java Virtual Machine. You can obtain the {@link ServletContext} by calling the {@code getServletContext}
     * method on the {@link ServletConfig}. In addition, there is also the same method on the {@link ServletRequest}
     * that returns the same {@link ServletContext}. Objects store in {@link ServletContext} are called attributes.
     */
    @Test
    @DisplayName("ServletContext interface methods")
    public void servletContextMethods(){
        // Setting the value of an attribute in a Context
        servletContext.setAttribute(ATTRIBUTE_NAME, ATTRIBUTE_VALUE);

        // Getting the value of an attribute in a Context

        Assertions.assertEquals(ATTRIBUTE_VALUE, servletContext.getAttribute(ATTRIBUTE_NAME));

        // Removing the value of an attribute in a Context

        servletContext.removeAttribute(ATTRIBUTE_NAME);
    }
}
