package pt.ist.rest.domain.exception;

/**
 * This exception will be thrown when a restaurant is not found on the application.
 *
 * @see Restaurant
 */
public class UserNotFoundException extends
        RestException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6676390319218917913L;
    
    /** The username. */
    private final String username;

    /**
     * Instantiates a new user not found exception.
     *
     * @param name the name
     */
    public UserNotFoundException(String name) {
        super();
        this.username = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format("O utilizador com o nome %s nao foi encontrado", this.username);
    }
}
