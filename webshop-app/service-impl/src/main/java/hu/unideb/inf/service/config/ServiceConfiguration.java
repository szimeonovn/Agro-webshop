package hu.unideb.inf.service.config;

import hu.unideb.inf.persistence.config.PersistenceConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * This class provides the configuration of the module.
 */

@Configuration
@Import(PersistenceConfiguration.class)
@ComponentScan(basePackages = "hu.unideb.inf.service")
public class ServiceConfiguration {

    /**
     * Creates a new modelMapper instance which will be available for the other components.
     *
     * @return a ModelMapper
     */
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
