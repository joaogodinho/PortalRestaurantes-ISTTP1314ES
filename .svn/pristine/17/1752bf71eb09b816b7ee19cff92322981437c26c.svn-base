package pt.ist.rest.service.exception;

/**
 * The Class ServiceException.
 * 
 * All exceptions thrown by services extends this class.
 */
public abstract class ServiceException extends Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new service exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     */
    public ServiceException(String message) {
        super(message);
    }
    
    /**
     * 
     */
    public ServiceException() {
        super();
    }

    /**
     * Specific message. In order to add more specific meaning call
     * super.specificMessage() + ", ...".
     * 
     * VERY IMPORTANT: This exceptions are constructed with DTOs that must
     * override toString() method or else bad messages will appear!!!
     * 
     * @return the service exception specific message for that problem.
     */
    protected abstract String specificMessage();

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return super.getMessage() + ": [" + specificMessage() + "]";
    }

}
