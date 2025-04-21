package it.mauluk92.servlet.c1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;

/**
 * This class contains tests to validate rules about
 * web.xml deployment descriptor
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class UsingDeploymentDescriptorTest {

    /**
     * One aspect of deployment is configuring the mapping of your servlet with a path.
     * Using the deployment descriptor is another way of configuring a servlet application and
     * the deployment descriptor. It is always named <strong>web.xml</strong> and located
     * under a <strong>WEB-INF</strong> directory. There are certain advantages of using the deployment
     * descriptor. For one, you include elements that have no equivalent in {@link WebServlet} such as
     * <strong>load-on-startup</strong> element. This element loads the servlet at application start-up,
     * rather than when the servlet is first called. This is especially useful if the <strong>init</strong>
     * method of the servlet takes a while to complete.
     */
    @Test
    @DisplayName("Using a deployment descriptor")
    public void usingDeploymentDescriptor() throws IOException {
        Resource webXml = new ClassPathResource("c1/using_deployement_descriptor/web.xml");
        Files.readAllLines(webXml.getFile().toPath()).forEach(System.out::println);
    }
}
