
package hu.unideb.inf.web.rest.controllers.config;

import hu.unideb.inf.service.config.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * This class provides the configuration of the web module.
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {"hu.unideb.inf.web.rest.controllers", "hu.unideb.inf.web.rest.controllers.creator",
        "hu.unideb.inf.web.rest.controllers.security"})
public class WebConfiguration {
}
