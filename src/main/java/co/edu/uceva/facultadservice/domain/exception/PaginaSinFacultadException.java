package co.edu.uceva.facultadservice.domain.exception;

public class PaginaSinFacultadException extends RuntimeException {
    public PaginaSinFacultadException(int page) {
        super("No hay facultades en la página solicitada: " + page);
    }
}