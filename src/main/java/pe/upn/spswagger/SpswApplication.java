package pe.upn.spswagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpswApplication {

    private static final Logger log = LoggerFactory.getLogger(SpswApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpswApplication.class, args);
        Environment env = context.getEnvironment();

        String port = env.getProperty("local.server.port", "8080");
        String host = env.getProperty("server.address", "localhost");
        String baseUrl = "http://" + host + ":" + port;

        log.info("🚀 API de Personas iniciada en {}", baseUrl);
        log.info("📖 Swagger UI: {}/swagger-ui.html", baseUrl);
        log.info("🗄️  Consola H2: {}/h2-console", baseUrl);
    }

}
