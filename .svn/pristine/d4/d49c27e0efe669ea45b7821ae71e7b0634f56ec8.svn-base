package pt.ist.rest.domain;

/**
 * The Class User.
 */
public class User extends
        User_Base {


    /**
     * Instantiates a new user.
     */
    public User() {
        super();
    }

    /**
     * Instantiates a new user.
     * 
     * @param username the user's username
     * @param password the user's password
     */
    public User(String username, String password) {
        super();
        init(username, password);
    }

    /**
     * Instantiates a new user since the FF doesn't support this class subclasses to use
     * the super(String, String).
     * 
     * @param username the user's username
     * @param password the user's password
     */
    protected void init(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    @Override
    public void setPortal(RestaurantPortal portal) {
        portal.addUser(this);
    }
}
