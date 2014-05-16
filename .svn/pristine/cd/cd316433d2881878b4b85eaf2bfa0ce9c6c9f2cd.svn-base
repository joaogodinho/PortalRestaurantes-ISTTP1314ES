package pt.ist.rest.service.dto;

/**
 * The Class UserDto.
 */
public class UserDto
        implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1797902121076085097L;

    /** The name. */
    protected String name;

    /** The password. */
    protected String password;

    /** The username. */
    protected String username;

    /**
     * Instantiates a new user dto.
     * 
     * @param username the username
     * @param password the password
     * @param name the name
     */
    public UserDto(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    /**
     * Instantiates a new user dto.
     * 
     * @param username the username
     * @param password the password
     */
    public UserDto(String username, String password) {
        this(username, password, "");
    }

    public UserDto() { }
    
    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username.
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return this.getUsername() + " | Nome: " + this.getName() + " | Password: " + this.getPassword(); 
    }

}
