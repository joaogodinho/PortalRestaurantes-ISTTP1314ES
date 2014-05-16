package pt.ist.rest.domain.service.test;

import java.util.Set;

import junit.framework.TestCase;
import jvstm.Atomic;
import pt.ist.fenixframework.Config;
import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.Utilities.FoodType;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.Manager;
import pt.ist.rest.domain.OpenCart;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.PlateQuantity;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.User;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class RestServiceTest.
 */
public abstract class RestServiceTest extends
        TestCase {

    static {
        if (FenixFramework.getConfig() == null) {
            FenixFramework.initialize(new Config() {
                {
                    domainModelPath = "src/main/dml/rest.dml";
                    dbAlias = "//localhost:3306/restdb";
                    dbUsername = "rest";
                    dbPassword = "r3st";
                    rootClass = RestaurantPortal.class;
                }
            });
        }
    }

    /**
     * Instantiates a new rest service test.
     * 
     * @param msg the message
     */
    protected RestServiceTest(String msg) {
        super(msg);
    }

    /**
     * Instantiates a new rest service test.
     */
    protected RestServiceTest() {
        super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        cleanDatabase();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        cleanDatabase();
    }

    /**
     * Clean database.
     */
    @Atomic
    private void cleanDatabase() {
        RestaurantPortal portal = FenixFramework.getRoot();

        // Clear All Restaurants
        Set<Restaurant> allRestaurants = portal.getRestaurantSet();
        allRestaurants.clear();

        // Clear All Users
        Set<User> allUsers = portal.getUserSet();
        allUsers.clear();
    }

    /**
     * Gets the restaurant.
     * 
     * @param name the name
     * @return the restaurant
     */
    private Restaurant getRestaurant(String name) {
        RestaurantPortal portal = FenixFramework.getRoot();
        return portal.getRestaurantByName(name);
    }

    /**
     * Gets the manager.
     *
     * @param username the username
     * @return the manager
     */
    private Manager getManager(String username) {
        RestaurantPortal portal = FenixFramework.getRoot();
        return portal.getManagerByUsername(username);
    }

    /**
     * Gets the plate.
     * 
     * @param plateName the plate name
     * @param restaurantName the restaurant name
     * @return the plate
     */
    private Plate getPlate(String plateName, String restaurantName) {
        Restaurant restaurant = getRestaurant(restaurantName);
        return restaurant.getPlateByName(plateName);
    }

    /**
     * Gets the client.
     *
     * @param username the username
     * @return the client
     */
    private Client getClient(String username) {
        RestaurantPortal portal = FenixFramework.getRoot();
        return portal.getClientByUsername(username);
    }

    /**
     * Check restaurant.
     * 
     * @param name the name
     * @return true, if successful
     */
    @Atomic
    protected boolean checkRestaurant(String name) {
        return getRestaurant(name) != null;
    }

    /**
     * Check manager.
     *
     * @param username the username
     * @return true, if successful
     */
    @Atomic
    protected boolean checkManager(String username) {
        return getManager(username) != null;
    }

    /**
     * Check plate.
     * 
     * @param plateName the plate name
     * @param restaurantName the restaurant name
     * @return true, if successful
     */
    @Atomic
    protected boolean checkPlate(String plateName, String restaurantName) {
        return getPlate(plateName, restaurantName) != null;
    }

    /**
     * Check client.
     *
     * @param username the username
     * @return true, if successful
     */
    @Atomic
    protected boolean checkClient(String username) {
        return getClient(username) != null;
    }

    /**
     * Check client open cart.
     *
     * @param username the username
     * @return true, if successful
     */
    @Atomic
    protected boolean checkClientOpenCart(String username) {
        Client client = getClient(username);
        return client.hasOpenCart();
    }

    /**
     * Check client open cart number of different plates.
     *
     * @param username the username
     * @param numberOfPlates the number of plates
     * @return true, if successful
     */
    @Atomic
    protected boolean checkClientOpenCartNumberOfDifferentPlates(String username, int numberOfPlates) {
        Client client = getClient(username);
        if (!client.hasOpenCart())
            return numberOfPlates == 0;
        OpenCart cart = client.getOpenCart();
        return cart.getPlateQuantityCount() == numberOfPlates;
    }

    /**
     * Check client open cart has plate.
     *
     * @param username the username
     * @param plateName the plate name
     * @return true, if successful
     */
    @Atomic
    protected boolean checkClientOpenCartHasPlate(String username, String plateName) {
        Client client = getClient(username);
        if (!client.hasOpenCart())
            return false;
        OpenCart cart = client.getOpenCart();
        return cart.hasPlateQuantityByName(plateName);
    }

    /**
     * Check client open cart has plate quantity.
     *
     * @param username the username
     * @param plateName the plate name
     * @param quantity the quantity
     * @return true, if successful
     */
    @Atomic
    protected boolean checkClientOpenCartHasPlateQuantity(String username,
                                                          String plateName,
                                                          int quantity) {
        Client client = getClient(username);
        OpenCart cart = client.getOpenCart();
        if (!cart.hasPlateQuantityByName(plateName))
            return quantity == 0;
        PlateQuantity plateQuantity = cart.getPlateQuantityByName(plateName);
        return plateQuantity.getQuantity() == quantity;
    }


    /**
     * Adds the restaurant.
     *
     * @param name the name
     * @param address the address
     * @return the restaurant dto
     */
    @Atomic
    protected SimpleRestaurantDto addRestaurant(String name, String address) {
        RestaurantPortal portal = FenixFramework.getRoot();
        Restaurant restaurant = new Restaurant(name, address);
        portal.addRestaurant(restaurant);
        return new SimpleRestaurantDto(name, address);
    }

    /**
     * Adds the manager.
     *
     * @param username the username
     * @param password the password
     * @param name the name
     * @return the manager dto
     */
    @Atomic
    protected SimpleManagerDto addManager(String username, String password, String name) {
        RestaurantPortal portal = FenixFramework.getRoot();
        Manager manager = new Manager(username, password, name);
        portal.addUser(manager);
        return new SimpleManagerDto(username, password, name);
    }

    /**
     * Adds the manager to restaurant.
     * 
     * @param username the manager's username
     * @param restaurantName the restaurant name
     */
    @Atomic
    protected void addManagerToRestaurant(String username, String restaurantName) {
        Restaurant restaurant = getRestaurant(restaurantName);
        Manager manager = getManager(username);
        restaurant.addManager(manager);
    }


    /**
     * Adds the plate to restaurant.
     *
     * @param plateName the plate name
     * @param type the type
     * @param calories the calories
     * @param price the price
     * @param restaurantDto the restaurant dto
     * @param managerDto the manager dto
     * @return the plate dto
     */
    @Atomic
    protected PlateDto addPlateToRestaurant(String plateName,
                                        String type,
                                        double calories,
                                        double price,
                                        SimpleRestaurantDto restaurantDto,
                                        SimpleManagerDto managerDto) {
        Restaurant restaurant = getRestaurant(restaurantDto.getName());
        Manager manager = getManager(managerDto.getUsername());
        Plate plate = new Plate(plateName, calories, price);
        restaurant.addAvailablePlate(manager, plate);
        //TODO Corrigir teste para aceitar alimentos e nao calcular tipo 'a partida
        return new PlateDto(plate.getId(), plateName, type, calories, price, restaurantDto);
    }

    
    /**
     * Adds the client.
     *
     * @param username the username
     * @param password the password
     * @param name the name
     * @param email the email
     * @param address the address
     * @param nif the nif
     * @return the client dto
     */
    @Atomic
    protected SimpleClientDto addClient(String username,
                             String password,
                             String name,
                             String email,
                             String address,
                             int nif) {
        RestaurantPortal portal = FenixFramework.getRoot();
        Client client = new Client(username, password, name, email, address, nif);
        portal.addUser(client);
        return new SimpleClientDto(username, password, name, email, address, nif);
    }
    
    /**
     * Adds the plate to client open cart.
     *
     * @param clientDto the client dto
     * @param plateDto the plate dto
     * @param quantity the quantity
     */
    @Atomic
    protected void addPlateToClientOpenCart(SimpleClientDto clientDto, PlateDto plateDto, int quantity) {
        Client client = getClient(clientDto.getUsername());
        Plate plate = getPlate(plateDto.getName(), plateDto.getRestaurantDto().getName());
        client.addPlateToCart(plate, quantity);
    }
}
