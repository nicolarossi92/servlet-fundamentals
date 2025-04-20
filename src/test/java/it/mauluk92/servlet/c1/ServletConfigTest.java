package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.util.*;

/**
 * This class contains tests to validate rules about
 * {@link ServletConfig} and its methods
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ServletConfigTest {

    private final static String PARAMETER_NAME = "NAME";
    private final static String PARAMETER_VALUE = "VALUE";

    @Mock
    private ServletConfig servletConfig;

    @BeforeEach
    public void setup(){
        Mockito.when(servletConfig.getInitParameter(Mockito.any())).thenReturn(PARAMETER_VALUE);
    }

    /**
     * The servlet container passes a {@link ServletConfig} to the servlet {@code init} method when
     * the servlet container initializes the servlet. The {@link ServletConfig} encapsulates
     * the configuration information that you can pass to a servlet through {@link WebServlet}
     * or the deployment descriptor. The deployment descriptor is an XML file that contain configuration values.
     * It may or may not be present in a servlet/JSP application.
     * Every piece of information passed to the {@link ServletConfig} is called an initial parameter.
     * An initial parameter has two components: key and value.
     * To retrieve the value of an initial parameter from inside a servlet, call the {@code getInitParameter} method on the
     * {@link ServletConfig}. In addition, the {@code getInitParameterNames} returns an {@link Enumeration} of all initial
     * parameter names
     */
    @Test
    @DisplayName("ServletConfig interface methods")
    public void servletConfigMethods(){
        // ServletConfig initial parameter are available through key/value pairs
        // They can be recovered by name
        Assertions.assertEquals(PARAMETER_VALUE, servletConfig.getInitParameter(PARAMETER_NAME));
    }
}
