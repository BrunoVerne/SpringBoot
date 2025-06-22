package Spring.Proyecto.exception;

public class PeliculaSerieExistException extends RuntimeException {
    public PeliculaSerieExistException() {
    }

    public PeliculaSerieExistException(String message) {
        super(message);
    }

    public PeliculaSerieExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
