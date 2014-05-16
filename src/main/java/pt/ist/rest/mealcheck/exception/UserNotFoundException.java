package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class UserNotFoundException.
 */
public class UserNotFoundException extends
        Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -2103085754040145255L;
    
    /**
     * The username.
     */
    private String username;

    /**
     * Instantiates a new utilizador inexistente_ exception.
     *
     * @param username the fault info
     */
    public UserNotFoundException(String username) {
        super("User with username " + username + " doesn't exist");
        this.username = username;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public UserNotFoundException() {
        super();
    }
}
