package co.edu.uco.openresort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class


OpenresortApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenresortApplication.class, args);
    }

    //CORS
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(Credenciales.DOMINIO_FRONTEND).allowedMethods("*").allowedHeaders("*");
            }
        };
    }

}
