package hu.unideb.inf.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@Configuration //config osztályok javaban
@EntityScan(basePackages = "hu.unideb.inf.persistence.entity") //hol keresse az entityket, mely pkg alatt
@EnableJpaRepositories(basePackages = "hu.unideb.inf.persistence.repository") //repokat hol keresse
public class PersistenceConfiguration {
}
