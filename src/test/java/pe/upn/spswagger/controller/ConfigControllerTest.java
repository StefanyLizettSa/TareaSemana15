package pe.upn.spswagger.controller;

import org.junit.jupiter.api.Test;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConfigControllerTest {

    @Test
    void shouldNormalizeHostnameBasedApiUrlToAbsoluteUrl() {
        Environment env = mock(Environment.class);
        when(env.getProperty("api.url", "http://localhost:8080/api/personas"))
                .thenReturn("tareasemana15-production.up.railway.app/api/personas");

        ConfigController controller = new ConfigController(env);

        String script = controller.getConfigScript().getBody();

        assertEquals("const API_URL = 'https://tareasemana15-production.up.railway.app/api/personas';", script);
    }
}
