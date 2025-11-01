package co.edu.uceva.facultadservice.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String descripcion;

    @NotEmpty(message = "La dirección no puede estar vacía")
    @Size(min = 5, max = 100, message = "La dirección debe tener entre 5 y 100 caracteres")
    @Column(nullable = false)
    private String direccion;

    @NotEmpty(message = "La ciudad no puede estar vacía")
    @Size(min = 2, max = 50, message = "La ciudad debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String ciudad;

    @NotNull(message = "Debe especificar los cupos")
    @Min(value = 1, message = "Debe haber al menos 1 cupo")
    @Max(value = 500, message = "No puede superar los 500 cupos")
    @Column(nullable = false)
    private Integer cupos;

    @Size(max = 100, message = "El nombre del archivo no puede exceder los 100 caracteres")
    @Pattern(
            regexp = "^[\\w,\\s-]+\\.(jpg|jpeg|png|gif|bmp|webp)$",
            message = "El nombre del archivo debe ser válido y tener una extensión permitida: jpg, jpeg, png, gif, bmp, webp"
    )
    private String foto;

}
