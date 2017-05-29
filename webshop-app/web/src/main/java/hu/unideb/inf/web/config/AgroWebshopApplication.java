package hu.unideb.inf.web.config;
import hu.unideb.inf.web.security.WebSecurityConfiguration;
import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfiguration.class, WebSecurityConfiguration.class})
public class AgroWebshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgroWebshopApplication.class, args);
    }

}
