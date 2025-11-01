package co.edu.uceva.facultadservice.domain.exception;

public class FacultadExistenteException extends RuntimeException {
    public FacultadExistenteException(String nombre) {
        super("la facultad con nombre '" + nombre + "' ya existe.");
    }
}

