package pt.ist.rest.service.exception;

/**
 * The Class WrongPasswordException.
 */
public class WrongPasswordException extends ServiceException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L; 
    
    /** The username. */
    private final String username;

    /**
     * Instantiates a new wrong password exception.
     *
     * @param username the username
     */
    public WrongPasswordException(String username) {
        super("A Password esta errada.");
        this.username = username;
    }
    
    
    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        return "A Password dada nao corresponde a do utilizador " + this.username;
    }
    
}
