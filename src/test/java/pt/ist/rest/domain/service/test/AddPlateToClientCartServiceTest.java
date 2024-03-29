package pt.ist.rest.domain.service.test;

import pt.ist.rest.service.AddPlateToClientCartService;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.UnableToRemoveUnexistentPlateException;
import pt.ist.rest.service.exception.UnknownPlateException;
import pt.ist.rest.service.exception.UnknownRestaurantException;
import pt.ist.rest.service.exception.UnknownUserException;



/**
 * The Class AddPlateToClientCartServiceTest.
 */
public class AddPlateToClientCartServiceTest extends
        RestServiceTest {

    /** The Constant RESTAURANT_NAME. */
    private static final String RESTAURANT_NAME = "Barriga Cheia";

    /** The Constant RESTAURANT_ADDRESS. */
    private static final String RESTAURANT_ADDRESS = "Lisboa, Portugal";


    /** The Constant MANAGER_NAME. */
    private static final String MANAGER_NAME = "Passos Lebre";

    /** The Constant MANAGER_PASSWORD. */
    private static final String MANAGER_PASSWORD = "mn8";

    /** The Constant MANAGER_USERNAME. */
    private static final String MANAGER_USERNAME = "mng";


    /** The Constant FIRST_PLATE_NAME. */
    private static final String FIRST_PLATE_NAME = "Bacalhau com Batatas";

    /** The Constant FIRST_PLATE_TYPE. */
    private static final String FIRST_PLATE_TYPE = "Peixe";

    /** The Constant FIRST_PLATE_CALORIES. */
    private static final double FIRST_PLATE_CALORIES = 200;

    /** The Constant FIRST_PLATE_PRICE. */
    private static final double FIRST_PLATE_PRICE = 5;


    /** The Constant SECOND_PLATE_NAME. */
    private static final String SECOND_PLATE_NAME = "Bitoque";

    /** The Constant SECOND_PLATE_TYPE. */
    private static final String SECOND_PLATE_TYPE = "Carne";

    /** The Constant SECOND_PLATE_CALORIES. */
    private static final double SECOND_PLATE_CALORIES = 500;

    /** The Constant SECOND_PLATE_PRICE. */
    private static final double SECOND_PLATE_PRICE = 7;


    /** The Constant CLIENT_USERNAME. */
    private static final String CLIENT_USERNAME = "zeze";

    /** The Constant CLIENT_PASSWORD. */
    private static final String CLIENT_PASSWORD = "z3z3";

    /** The Constant CLIENT_NAME. */
    private static final String CLIENT_NAME = "Ze Ninguem";

    /** The Constant CLIENT_EMAIL. */
    private static final String CLIENT_EMAIL = "ze.ninguem@ist.utl.pt";

    /** The Constant CLIENT_ADDRESS. */
    private static final String CLIENT_ADDRESS = "Lisboa, Portugal";

    /** The Constant CLIENT_NIF. */
    private static final int CLIENT_NIF = 123456789;


    /** The restaurant. */
    private SimpleRestaurantDto restaurant;


    /** The manager. */
    private SimpleManagerDto manager;


    /** The first plate. */
    private PlateDto firstPlate;

    /** The second plate. */
    private PlateDto secondPlate;


    /** The client. */
    private SimpleClientDto client;


    /**
     * Instantiates a new adds the plate to client cart service test.
     */
    public AddPlateToClientCartServiceTest() {
        super();
    }

    /**
     * Instantiates a new adds the plate to client cart service test.
     * 
     * @param msg the msg
     */
    public AddPlateToClientCartServiceTest(String msg) {
        super(msg);
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.test.RestServiceTest#setUp()
     */
    @Override
    public void setUp() throws Exception {
        try {
        super.setUp();

        restaurant = addRestaurant(RESTAURANT_NAME, RESTAURANT_ADDRESS);

        manager = addManager(MANAGER_USERNAME, MANAGER_PASSWORD, MANAGER_NAME);
        addManagerToRestaurant(MANAGER_USERNAME, RESTAURANT_NAME);

        firstPlate = addPlateToRestaurant(FIRST_PLATE_NAME, FIRST_PLATE_TYPE, FIRST_PLATE_CALORIES,
                FIRST_PLATE_PRICE, restaurant, manager);
        secondPlate = addPlateToRestaurant(SECOND_PLATE_NAME, SECOND_PLATE_TYPE,
                SECOND_PLATE_CALORIES, SECOND_PLATE_PRICE, restaurant, manager);

        client = addClient(CLIENT_USERNAME, CLIENT_PASSWORD, CLIENT_NAME, CLIENT_EMAIL,
                CLIENT_ADDRESS, CLIENT_NIF);
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * Test add one plate to client cart.
     */
    public void testAddOnePlateToClientCart() {
        // Arrange
        final int quantity = 5;
        final AddPlateToClientCartService service = new AddPlateToClientCartService(client,
                firstPlate, quantity);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }

        // Assert
        assertTrue("Was not able to create an Open Cart", checkClientOpenCart(CLIENT_USERNAME));

        assertTrue("Did not add one plate to client cart",
                checkClientOpenCartNumberOfDifferentPlates(CLIENT_USERNAME, 1));

        assertTrue("Did not add correct plate to an empty Open Cart",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, FIRST_PLATE_NAME));
        assertTrue("Did not add correct quantity to an empty Open Cart",
                checkClientOpenCartHasPlateQuantity(CLIENT_USERNAME, FIRST_PLATE_NAME, quantity));
    }

    /**
     * Test add two different plates to client cart.
     */
    public void testAddTwoDifferentPlatesToClientCart() {
        // Arrange
        final int fistPlateQuantity = 5;
        final AddPlateToClientCartService firstPlateService = new AddPlateToClientCartService(
                client, firstPlate, fistPlateQuantity);

        final int secondPlateQuantity = 2;
        final AddPlateToClientCartService secondPlateService = new AddPlateToClientCartService(
                client, secondPlate, secondPlateQuantity);

        // Act
        try {
            firstPlateService.execute();
            secondPlateService.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }

        // Assert
        assertTrue("Was not able to create an Open Cart", checkClientOpenCart(CLIENT_USERNAME));

        assertTrue("Did not add two plates to client cart",
                checkClientOpenCartNumberOfDifferentPlates(CLIENT_USERNAME, 2));

        assertTrue("Did not add the first plate to client cart",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, FIRST_PLATE_NAME));
        assertTrue("Did not add the second plate to client cart",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, SECOND_PLATE_NAME));

        assertTrue(
                "Did not add the first plate's quantity correctly to client cart",
                checkClientOpenCartHasPlateQuantity(CLIENT_USERNAME, FIRST_PLATE_NAME,
                        fistPlateQuantity));
        assertTrue(
                "Did not add the second plate's quantity correctly to client cart",
                checkClientOpenCartHasPlateQuantity(CLIENT_USERNAME, SECOND_PLATE_NAME,
                        secondPlateQuantity));
    }

    /**
     * Test add same plate twice to client cart.
     */
    public void testAddSamePlateTwiceToClientCart() {
        // Arrange
        final int fistTimeQuantity = 5;
        final AddPlateToClientCartService firstTimeService = new AddPlateToClientCartService(
                client, firstPlate, fistTimeQuantity);

        final int secondTimeQuantity = 2;
        final AddPlateToClientCartService secondTimeService = new AddPlateToClientCartService(
                client, firstPlate, secondTimeQuantity);

        // Act
        try {
            firstTimeService.execute();
            secondTimeService.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }

        // Assert
        assertTrue("Was not able to create an Open Cart", checkClientOpenCart(CLIENT_USERNAME));

        assertTrue("Did not add one plate to client cart",
                checkClientOpenCartNumberOfDifferentPlates(CLIENT_USERNAME, 1));

        assertTrue("Did not add the correct plate to client cart",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, FIRST_PLATE_NAME));

        assertTrue(
                "Did not add the plate's quantity correctly to client cart",
                checkClientOpenCartHasPlateQuantity(CLIENT_USERNAME, FIRST_PLATE_NAME,
                        fistTimeQuantity + secondTimeQuantity));
    }

    /**
     * Test add one plate and remove it from client cart.
     */
    public void testAddOnePlateAndRemoveItFromClientCart() {
        // Arrange
        final int addQuantity = 5;
        final AddPlateToClientCartService addService = new AddPlateToClientCartService(client,
                firstPlate, addQuantity);
        final int removeQuantity = -addQuantity;
        final AddPlateToClientCartService removeService = new AddPlateToClientCartService(client,
                firstPlate, removeQuantity);

        // Act
        try {
            addService.execute();
            removeService.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }

        // Assert
        assertTrue("Was not able to create an Open Cart", checkClientOpenCart(CLIENT_USERNAME));

        assertFalse("Did not correctly remove the plate after adding it and trying to remove",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, FIRST_PLATE_NAME));
    }

    /**
     * Test add one plate and remove some quantity from client cart.
     */
    public void testAddOnePlateAndRemoveSomeQuantityFromClientCart() {
        // Arrange
        final int addQuantity = 5;
        final AddPlateToClientCartService addService = new AddPlateToClientCartService(client,
                firstPlate, addQuantity);
        final int removeQuantity = -3;
        final AddPlateToClientCartService removeService = new AddPlateToClientCartService(client,
                firstPlate, removeQuantity);

        // Act
        try {
            addService.execute();
            removeService.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }

        // Assert
        assertTrue("Was not able to create an Open Cart", checkClientOpenCart(CLIENT_USERNAME));

        assertTrue("Did not add one plate to client cart",
                checkClientOpenCartNumberOfDifferentPlates(CLIENT_USERNAME, 1));

        assertTrue("Did not add the correct plate to client cart",
                checkClientOpenCartHasPlate(CLIENT_USERNAME, FIRST_PLATE_NAME));

        assertTrue(
                "Did not deduce the plate's quantity correctly to client cart",
                checkClientOpenCartHasPlateQuantity(CLIENT_USERNAME, FIRST_PLATE_NAME, addQuantity
                        + removeQuantity));
    }

    /**
     * Test add one plate with negative quantity to client cart.
     */
    public void testAddOnePlateWithNegativeQuantityToClientCart() {
        // Arrange
        final int quantity = -5;
        final AddPlateToClientCartService service = new AddPlateToClientCartService(client,
                firstPlate, quantity);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (UnableToRemoveUnexistentPlateException utrupe) {
            assertTrue("Wrong parametre in exception", utrupe.getPlate().getId() == firstPlate.getId());
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }
    }

    /**
     * Test add inexistent plate to client cart.
     */
    public void testAddInexistentPlateToClientCart() {
        //Arrange
        final int fakePlateId = -1;
        final String fakePlateName = "Canja de Galinha";
        final String fakePlateType = "Carne";
        final double fakePlateCalories = 300;
        final double fakePlatePrice = 12;
        final PlateDto fakePlate = new PlateDto(fakePlateId, fakePlateName, fakePlateType,
                fakePlateCalories, fakePlatePrice, restaurant);

        final int quantity = 5;
        final AddPlateToClientCartService service = new AddPlateToClientCartService(client,
                fakePlate, quantity);

        // Act
        try {
            service.execute();
            fail("Sucessfully added a plate that does not exist in the database to a client");

            // Assert
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            assertTrue("Wrong parameter in exception", upe.getPlate().getId() == fakePlateId);
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client when trying to add a plate to it's Open Cart");
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }
    }

    /**
     * Test add plate to inexistent client cart.
     */
    public void testAddPlateToInexistentClientCart() {
        // Arrange
        final int fakeClientNIF = 987654321;
        final String fakeClientUsername = "mariazinha";
        final String fakeClientPassword = "****";
        final String fakeClientName = "Maria Silva";
        final String fakeClientEmail = "maria.silva@ist.utl.pt";
        final String fakeClientAddress = "Porto, Portugal";
        final SimpleClientDto fakeClient = new SimpleClientDto(fakeClientUsername,
                fakeClientPassword, fakeClientName, fakeClientEmail, fakeClientAddress,
                fakeClientNIF);
        final int quantity = 5;
        final AddPlateToClientCartService service = new AddPlateToClientCartService(fakeClient,
                firstPlate, quantity);

        // Act
        try {
            service.execute();
            fail("Sucessfully added a plate to a client that does not exist in the database");

            // Assert
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existing restaurant when trying to add a plate to a client's Open Cart");
        } catch (UnknownPlateException upe) {
            fail("Failed to find an existing plate when trying to add it to a client's Open Cart");
        } catch (UnknownUserException uue) {
            assertTrue("Wrong parameter in exception", uue.getUser().getUsername() == fakeClientUsername);
        } catch (Exception se) {
            fail("Unexpected exception thrown while trying to add a plate to a client's Open Cart");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.test.RestServiceTest#tearDown()
     */
    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        restaurant = null;
        manager = null;
        firstPlate = null;
        secondPlate = null;
        client = null;
    }

}
