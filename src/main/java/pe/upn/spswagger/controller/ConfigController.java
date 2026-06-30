package pe.upn.spswagger.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private final Environment env;

    public ConfigController(Environment env) {
        this.env = env;
    }

    @GetMapping(value = "/config.js", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getConfigScript() {
        String apiUrl = env.getProperty("api.url", "http://localhost:8080/api/personas");
        String script = "const API_URL = '" + apiUrl.replace("'", "\\'") + "';";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/javascript"))
                .body(script);
    }
}
