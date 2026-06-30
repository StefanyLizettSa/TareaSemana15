
package pe.upn.spswagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
     @Bean
    public OpenAPI apiPersonasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST de Personas")
                        .description("CRUD de personas con paginación de 7 en 7, documentado con Swagger")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Stefany Lizett")
                                .email("stefmontoya@gmail.com")));
    }
}
