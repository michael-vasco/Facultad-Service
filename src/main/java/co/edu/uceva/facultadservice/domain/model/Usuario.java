package co.edu.uceva.facultadservice.domain.model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nombreCompleto;

    @NotEmpty(message = "El correo no puede estar vacío")
    @Column(nullable = false)
    private String correo;

    @NotEmpty(message = "la contraseña no puede estar vacío")
    @Size(min = 8, max = 18, message = "la contraseña debe tener entre 8 y 18 caracteres")
    @Column(nullable = false)
    private String contrasena;

    @NotNull(message = "Debe especificar la cedula")
    @Min(value = 9, message = "Debe haber al menos 9 valor")
    private Long cedula;

    @NotNull(message = "Debe especificar el telefono")
    @Min(value = 10, message = "Debe haber al menos 10 valores")
    private Long telefono;

    @NotEmpty(message = "El rol no puede estar vacío")
    @Size(min = 2, max = 50, message = "El rol debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String rol;
}