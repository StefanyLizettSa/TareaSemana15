package pe.upn.spswagger.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pe.upn.spswagger.dto.PersonaDTO;
import pe.upn.spswagger.service.PersonaService;

import java.net.URI;

@RestController
@RequestMapping("/api/personas")
@Tag(name = "Personas", description = "CRUD de personas con paginación de 7 en 7")
public class PersonaController {
  private static final int TAMANO_PAGINA = 7;
    private final PersonaService personaService;
    
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    @GetMapping
    @Operation(summary = "Listar personas paginadas (7 por página)")
    public ResponseEntity<Page<PersonaDTO>> listar(
            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, TAMANO_PAGINA, Sort.by("id").ascending());
        return ResponseEntity.ok(personaService.listar(pageable));
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una persona por su id")
    public ResponseEntity<PersonaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.obtenerPorId(id));
    }
    
    @PostMapping
    @Operation(summary = "Crear una nueva persona")
    public ResponseEntity<PersonaDTO> crear(
            @Valid @RequestBody PersonaDTO personaDTO,
            UriComponentsBuilder uriBuilder) {
        PersonaDTO creada = personaService.crear(personaDTO);
        URI ubicacion = uriBuilder.path("/api/personas/{id}")
                .buildAndExpand(creada.getId()).toUri();
        return ResponseEntity.created(ubicacion).body(creada);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una persona existente")
    public ResponseEntity<PersonaDTO> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PersonaDTO personaDTO) {
        return ResponseEntity.ok(personaService.actualizar(id, personaDTO));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una persona por su id")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/seed")
    @Operation(summary = "Insertar los 20 registros demo (seeder)")
    public ResponseEntity<String> seed() {
        int insertados = personaService.sembrarDatosDemo();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Seeder ejecutado. Registros insertados: " + insertados);
    }
}