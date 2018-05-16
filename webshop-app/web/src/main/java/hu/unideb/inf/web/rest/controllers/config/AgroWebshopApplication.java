package hu.unideb.inf.web.rest.controllers.config;

import hu.unideb.inf.web.rest.controllers.security.WebSecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * This class is responsible for starting the application as a Spring-boot application.
 */
@SpringBootApplication
@Import({WebConfiguration.class, WebSecurityConfiguration.class})
public class AgroWebshopApplication {
    /**
     * This method is responsible for starting the application as a Spring-boot application.
     *
     * @param args the expected arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AgroWebshopApplication.class, args);
    }

}
