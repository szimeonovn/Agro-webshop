package hu.unideb.inf.web.config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebConfiguration.class})
public class AgroWebshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgroWebshopApplication.class, args);
    }

}
