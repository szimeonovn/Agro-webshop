package hu.unideb.inf.web.config;

import hu.unideb.inf.service.config.ServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {"hu.unideb.inf.web.rest", "hu.unideb.inf.web.creator"})
public class WebConfiguration {
}
