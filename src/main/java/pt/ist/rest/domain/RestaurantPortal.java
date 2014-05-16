package pt.ist.rest.domain;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.Utilities.FoodType;
import pt.ist.rest.Utilities.Acceptable;
import pt.ist.rest.domain.exception.RestaurantNotFoundException;
import pt.ist.rest.domain.exception.UserNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * Application root class. This class contains all restaurants and users managed by this
 * platform.
 */
public class RestaurantPortal extends
        RestaurantPortal_Base {
    
    /**
     * The generated id.
     */
    private static int generatedID = 0;

    /**
     * Instantiates a new restaurant portal.
     */
    public RestaurantPortal() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.RestaurantPortal_Base#addRestaurant(pt.ist.rest.domain
     * .Restaurant)
     */
    @Override
    public void addRestaurant(Restaurant restaurant) {
        if (hasRestaurant(restaurant)) {
            throw new IllegalArgumentException(String.format(
                    "Ja existe um restaurante com o nome %s", restaurant.getName()));
        } else {
            super.addRestaurant(restaurant);
        }
    }


    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.RestaurantPortal_Base#addUser(pt.ist.rest.domain.User)
     */
    @Override
    public void addUser(User user) {
        if (this.hasUser(user)) {
            throw new IllegalArgumentException(String.format(
                    "Ja existe um Utilizador com o username %s", user.getUsername()));
        } else {
            super.addUser(user);
        }
    }


    /**
     * Gets the restaurant by name.
     * 
     * @param name the name
     * @return the restaurant by name
     */
    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : getRestaurant()) {
            if (restaurant.getName().equals(name)) {
                return restaurant;
            }
        }
        throw new RestaurantNotFoundException(name);
    }

    /**
     * Gets the client by username.
     * 
     * @param username the name
     * @return the client by username
     */
    public Client getClientByUsername(String username) {
        for (User user : this.getUser()) {
            if (user.getUsername().equals(username) && (user instanceof Client)) {
                return (Client) user;
            }
        }
        throw new UserNotFoundException(username);
    }

    /**
     * Gets the user by username.
     * 
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username) {
        for (User user : this.getUser()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotFoundException(username);
    }

    /**
     * Gets the manager by username.
     * 
     * @param username the name
     * @return the manager by username
     */
    public Manager getManagerByUsername(String username) {
        for (User user : this.getUser()) {
            if (user.getUsername().equals(username) && (user instanceof Manager)) {
                return (Manager) user;
            }
        }
        throw new UserNotFoundException(username);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.RestaurantPortal_Base#hasRestaurant(pt.ist.rest.domain
     * .Restaurant)
     */
    @Override
    public boolean hasRestaurant(Restaurant restaurant) {
        for (Restaurant rest : this.getRestaurantSet()) {
            if (rest.getName().equals(restaurant.getName())) {
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.RestaurantPortal_Base#hasUser(pt.ist.rest.domain.User)
     */
    @Override
    public boolean hasUser(User user) {
        for (User userElem : this.getUser()) {
            if (userElem.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generate id.
     *
     * @return the int
     */
    public static int generateID() {
        return generatedID++;
    }

    /**
     * Gets the plates by the given search type.
     *
     * @param searchType the acceptable class that defines which plates are acceptable for the search
     * @return the plates that match the acceptable conditions
     */
    public List<Plate> searchPlates(Acceptable searchType) {
        List<Plate> matchingPlates = new ArrayList<Plate>();
        for (Restaurant restaurant : this.getRestaurant()) {
            for (Plate plate : restaurant.getAvailablePlate()) {
                if (searchType.accept(plate)) {
                    matchingPlates.add(plate);
                }
            }
        }
        return matchingPlates;
    }
}
