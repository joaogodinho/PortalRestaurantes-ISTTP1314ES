package pt.ist.rest.domain.exception;

/**
 * The Class OperationNotAllowedException.
 */
public class OperationNotAllowedException extends
        RestaurantException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5155461945627176182L;

    private final String reason;
    
    /**
     * Instantiates a new operation not allowed exception.
     *
     * @param message the message
     */
    public OperationNotAllowedException(String message) {
        super();
        reason = message;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return "A operacao nao e permitida: " + reason;
    }

}
