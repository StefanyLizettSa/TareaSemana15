package pe.upn.spswagger.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
    @Column(unique = true, nullable = false, length = 8)
    private String dni;
    
    @NotBlank(message = "El apellido paterno es obligatorio")
    @Size(max = 50, message = "El apellido paterno no puede tener más de 50 caracteres")
    @Column(name = "apepaterno", nullable = false, length = 50)
    private String apepaterno;
    
    @Size(max = 50, message = "El apellido materno no puede tener más de 50 caracteres")
    @Column(name = "apematerno", length = 50)
    private String apematerno;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 100, message = "El correo no puede tener más de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String correo;
    
    // Constructores
    public Persona() {}
    
    public Persona(Long id, String dni, String apepaterno, String apematerno, String nombres, String correo) {
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
