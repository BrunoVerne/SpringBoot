package Spring.Proyecto.exception;

public class PersonajeExistException extends RuntimeException {
  public PersonajeExistException() {
  }

  public PersonajeExistException(String message) {
    super(message);
  }

  public PersonajeExistException(String message, Throwable cause) {
    super(message, cause);
  }
}
