package pt.ist.rest.domain.exception;

/**
 * The Class RestException is a exception base class for the
 * Rest program.
 */
public class RestException extends
        RuntimeException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1299309786642951316L;

    /**
     * Instantiates a new rest exception.
     *
     * @param message the message
     */
    public RestException(String message) {
        super(message);
    }
    
    /**
     * Instantiates a new rest exception.
     */
    public RestException() {
        super();
    }
}
