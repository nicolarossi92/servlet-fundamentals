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
 * HTML forms and {@link HttpServletRequest}
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class WorkingWithHTMLFormsTest {

    // Input fields rules

    private final static String INPUT_FIELD_NAME_FILLED = "INPUT_FIELD_NAME_FILLED";
    private final static String INPUT_FIELD_VALUE_FILLED = "VALUE";

    private final static String INPUT_FIELD_NAME_EMPTY = "INPUT_FIELD_NAME_EMPTY";
    private final static String INPUT_FIELD_VALUE_EMPTY = ""; // Never null

    // Select fields rules

    private final static String SELECT_ELEMENT_NAME = "SELECT_ELEMENT_NAME";
    private final static String SELECT_ELEMENT_OPTION = "OPTION";

    private final static String SELECT_ELEMENT_SECOND_OPTION = "SECOND_OPTION";

    // Checkbox rules

    private final static String CHECKBOX_ELEMENT_NAME = "CHECKBOX_ELEMENT_NAME";
    private final static String CHECKBOX_ELEMENT_VALUE = "on";
    // When unchecked returns null
    private final static String CHECKBOX_ELEMENT_NAME_UNCHECKED = "CHECKBOX_ELEMENT_NAME_UNCHECKED";
    private final static String CHECKBOX_ELEMENT_VALUE_UNCHECKED = null;

    // Radio buttons rules

    private final static String RADIO_ELEMENT_NAME_SELECTED = "RADIO_ELEMENT_NAME_SELECTED";
    private final static String RADIO_ELEMENT_VALUE_SELECTED = "RADIO_VALUE";

    private final static String RADIO_ELEMENT_NAME_NON_SELECTED = "RADIO_ELEMENT_NAME_NON_SELECTED";
    private final static String RADIO_ELEMENT_VALUE_NON_SELECTED = null;

    @Mock
    private HttpServletRequest httpServletRequest;

    @BeforeEach
    public void setup(){

        // Input fields

        Mockito.when(httpServletRequest.getParameter(INPUT_FIELD_NAME_FILLED))
                .thenReturn(INPUT_FIELD_VALUE_FILLED);
        Mockito.when(httpServletRequest.getParameter(INPUT_FIELD_NAME_EMPTY))
                .thenReturn(INPUT_FIELD_VALUE_EMPTY);

        // Select fields

        Mockito.when(httpServletRequest.getParameterValues(SELECT_ELEMENT_NAME))
                .thenReturn(new String[]{SELECT_ELEMENT_OPTION, SELECT_ELEMENT_SECOND_OPTION});

        // Checkbox fields

        Mockito.when(httpServletRequest.getParameter(CHECKBOX_ELEMENT_NAME))
                .thenReturn(CHECKBOX_ELEMENT_VALUE);
        Mockito.when(httpServletRequest.getParameter(CHECKBOX_ELEMENT_NAME_UNCHECKED))
                .thenReturn(CHECKBOX_ELEMENT_VALUE_UNCHECKED);

        // Radio fields

        Mockito.when(httpServletRequest.getParameter(RADIO_ELEMENT_NAME_SELECTED))
                .thenReturn(RADIO_ELEMENT_VALUE_SELECTED);
        Mockito.when(httpServletRequest.getParameter(RADIO_ELEMENT_NAME_NON_SELECTED))
                .thenReturn(RADIO_ELEMENT_VALUE_NON_SELECTED);

    }


    /**
     * A web application always contains one or more HTML forms to take
     * user input. You can easily send an HTML form from a servlet to the browser.
     * When the user submits the form, values entered in the form are set to the server
     * as <strong>request parameters</strong>.
     * <ul>
     *     <li>
     *         The value of an HTML input field (a text field, a hidden field, or a password field)
     *         or text area is sent to the server as a string. An empty input field or text area sends an empty
     *         string. As such, {@code ServletRequest.getParameter} that takes an input field name never
     *         returns null.
     *     </li>
     *     <li>
     *         An HTML select element also sends a string to the server. If none of the options in the select
     *         element is selected, the value of the option that is displayed is sent.
     *     </li>
     *     <li>
     *         A multiple value select element sends a string array and has to be handled
     *         by {@code ServletRequest.getParameterValues}.
     *     </li>
     *     <li>
     *         A checkbox is a bit extraordinary. A checked checkbox  sends the string "on" to the server.
     *         An unchecked checkbox sends nothing to the server and {@code ServletRequest.getParameter} returns null.
     *     </li>
     *     <li>
     *         Radio buttons sends the value of the selected button to the server. If none of the buttons
     *         is selected, nothing is sent to the server and {@code ServletRequest.getParameter}
     *         returns null.
     *     </li>
     *     <li>
     *         If a form contains multiple input elements with the same name, all values will be submitted and you have
     *         to use {@code ServletRequest.getParameterValues} to retrieve them. The getParameter will only return
     *         the last value.
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("HTML forms rules")
    public void htmlFormsRules(){

        // Input fields

        Assertions.assertEquals(INPUT_FIELD_VALUE_FILLED, httpServletRequest.getParameter(INPUT_FIELD_NAME_FILLED));
        Assertions.assertEquals(INPUT_FIELD_VALUE_EMPTY, httpServletRequest.getParameter(INPUT_FIELD_NAME_EMPTY));

        // Select fields

        Assertions.assertArrayEquals(new String[] {SELECT_ELEMENT_OPTION, SELECT_ELEMENT_SECOND_OPTION},
                httpServletRequest.getParameterValues(SELECT_ELEMENT_NAME));

        // Checkbox fields

        Assertions.assertEquals(CHECKBOX_ELEMENT_VALUE, httpServletRequest.getParameter(CHECKBOX_ELEMENT_NAME));
        Assertions.assertEquals(CHECKBOX_ELEMENT_VALUE_UNCHECKED, httpServletRequest.getParameter(CHECKBOX_ELEMENT_NAME_UNCHECKED));

        // Radio fields

        Assertions.assertEquals(RADIO_ELEMENT_VALUE_SELECTED, httpServletRequest.getParameter(RADIO_ELEMENT_NAME_SELECTED));
        Assertions.assertEquals(RADIO_ELEMENT_VALUE_NON_SELECTED, httpServletRequest.getParameter(RADIO_ELEMENT_NAME_NON_SELECTED));
    }
}
