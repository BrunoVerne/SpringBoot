package Spring.Proyecto.exception;

public class PersonajeNotFoundException extends RuntimeException {
  public PersonajeNotFoundException() {
  }

  public PersonajeNotFoundException(String message) {
    super(message);
  }

  public PersonajeNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
