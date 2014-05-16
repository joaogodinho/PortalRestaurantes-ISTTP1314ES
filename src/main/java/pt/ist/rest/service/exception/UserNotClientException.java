package pt.ist.rest.service.exception;

/**
 * The Class UserNotClientException.
 */
public class UserNotClientException extends ServiceException {
 
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The username. */
    private final String username;

    /**
     * Instantiates a new user not client.
     *
     * @param username the username
     */
    public UserNotClientException(String username) {
        super("O utilizador nao e cliente");
        this.username = username;
    }
    
    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        return "O utilizador " + this.username + " nao e cliente" ;
    }
}
