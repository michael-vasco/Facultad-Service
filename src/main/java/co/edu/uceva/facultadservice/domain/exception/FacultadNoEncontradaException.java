package co.edu.uceva.facultadservice.domain.exception;

public class FacultadNoEncontradaException extends RuntimeException {
    public FacultadNoEncontradaException(Long id) {
        super("la facultad con ID " + id + " no fue encontrada.");
    }
}