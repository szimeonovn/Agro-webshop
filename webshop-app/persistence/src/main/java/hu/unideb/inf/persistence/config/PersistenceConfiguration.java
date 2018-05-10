package hu.unideb.inf.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

/**
 * This class provides the configuration of the module.
 */
@Configuration
@EntityScan(basePackages = "hu.unideb.inf.persistence.entity")
@EnableJpaRepositories(basePackages = "hu.unideb.inf.persistence.repository")
public class PersistenceConfiguration {
}
