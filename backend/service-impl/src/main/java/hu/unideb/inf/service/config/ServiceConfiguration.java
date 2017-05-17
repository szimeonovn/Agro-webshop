package hu.unideb.inf.service.config;

import hu.unideb.inf.persistence.config.PersistenceConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceConfiguration.class)
@ComponentScan(basePackages = "hu.unideb.inf.service")
public class ServiceConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
