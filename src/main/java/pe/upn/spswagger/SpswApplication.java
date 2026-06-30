package pe.upn.spswagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpswApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpswApplication.class, args);
                System.out.println("🚀 API de Personas iniciada!");
                System.out.println("📖 Swagger UI: http://localhost:8080/swagger-ui.html");
                System.out.println("🗄️  Consola H2: http://localhost:8080/h2-console");
	}

}
