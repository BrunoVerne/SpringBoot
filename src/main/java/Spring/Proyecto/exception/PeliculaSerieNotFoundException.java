package Spring.Proyecto.exception;

public class PeliculaSerieNotFoundException extends RuntimeException {
    public PeliculaSerieNotFoundException() {
    }

    public PeliculaSerieNotFoundException(String message) {
        super(message);
    }

    public PeliculaSerieNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
