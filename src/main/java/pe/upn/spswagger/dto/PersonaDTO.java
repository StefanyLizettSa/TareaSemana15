package pe.upn.spswagger.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Datos de una persona que se intercambian con la API")
public class PersonaDTO {
    @Schema(description = "Identificador único autogenerado", example = "1")
    private Long id;
    
    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener exactamente 8 dígitos numéricos")
    @Schema(description = "Documento Nacional de Identidad (8 dígitos)", example = "70123456")
    private String dni;
    
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 50, message = "El apellido paterno no puede tener más de 50 caracteres")
    @Schema(description = "Apellido paterno", example = "Sánchez")
    private String apepaterno;
    
    @Size(max = 50, message = "El apellido materno no puede tener más de 50 caracteres")
    @Schema(description = "Apellido materno", example = "Pérez")
    private String apematerno;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Schema(description = "Nombre(s) de la persona", example = "Juan Carlos")
    private String nombres;
    
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Schema(description = "Correo electrónico", example = "juan.perez@email.com")
    private String correo;
    
    // Constructores
    public PersonaDTO() {}
    
    public PersonaDTO(Long id, String dni, String apepaterno, String apematerno, String nombres, String correo) {
        this.id = id;
        this.dni = dni;
        this.apepaterno = apepaterno;
        this.apematerno = apematerno;
        this.nombres = nombres;
        this.correo = correo;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    
    public String getApepaterno() { return apepaterno; }
    public void setApepaterno(String apepaterno) { this.apepaterno = apepaterno; }
    
    public String getApematerno() { return apematerno; }
    public void setApematerno(String apematerno) { this.apematerno = apematerno; }
    
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
