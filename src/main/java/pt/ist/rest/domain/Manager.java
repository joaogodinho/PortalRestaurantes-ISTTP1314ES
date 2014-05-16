package pt.ist.rest.domain;

/**
 * The Class Manager is a user that can
 * manage a restaurant.
 * It can be the manager of a single restaurant and
 * add or remove plates from it.
 */
public class Manager extends
        Manager_Base {

    /**
     * Manager constructor automatically generated. Don't use this constructor, give
     * preference to the following constructor: Manager(String, String, String)
     * 
     * @see Manager#Manager(String, String, String)
     */
    public Manager() {
        super();
    }

    /**
     * Manager constructor.
     *
     * @param username Manager's username for authentication
     * @param password Manager's password for authentication
     * @param name Manager's name
     */
    public Manager(String username, String password, String name) {
        super();
        init(username, password);
        setName(name);
    }

    /**
     * Adds a plate to the restaurant this Manager manages.
     *
     * @param plate the plate to be added to the restaurant
     */
    public void addAvailablePlate(Plate plate) {
        getRestaurant().addAvailablePlate(this, plate);
    }
    
    public void removeAvailablePlate(Plate plate){
        getRestaurant().removeAvailablePlate(this, plate);
    }

    @Override
    public void setRestaurant(Restaurant restaurant) {
        restaurant.addManager(this);
    }

    /*  (non-Javadoc)
     * @see pt.ist.fenixframework.pstm.AbstractDomainObject#toString()
     */
    @Override
    public String toString() {
        return "Manager: " + getUsername() + ", " + getName();
    }
}
