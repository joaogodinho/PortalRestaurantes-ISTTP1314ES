package pt.ist.rest.domain.service.test;

import pt.ist.rest.service.EmptyClientCartService;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class EmptyClientCartServiceTest.
 */
public class EmptyClientCartServiceTest extends
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
    public EmptyClientCartServiceTest() {
        super();
    }

    /**
     * Instantiates a new adds the plate to client cart service test.
     * 
     * @param msg the msg
     */
    public EmptyClientCartServiceTest(String msg) {
        super(msg);
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.test.RestServiceTest#setUp()
     */
    @Override
    public void setUp() throws Exception {
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
    }

    /**
     * Test empty existent client cart.
     */
    public void testEmptyExistentClientCart() {
        // TODO basic test for emptying the client's cart
        // Arrange
        final int firstPlateQuantity = 5;
        addPlateToClientOpenCart(client, firstPlate, firstPlateQuantity);

        final int secondPlateQuantity = 3;
        addPlateToClientOpenCart(client, secondPlate, secondPlateQuantity);

        final EmptyClientCartService service = new EmptyClientCartService(client);

        // Act
        try {
            service.execute();
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client to empty it's cart");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
        }

        // Assert
        assertFalse("Did not correctly empty an already empty client's Open Cart",
                checkClientOpenCart(CLIENT_USERNAME));
    }

    /**
     * Test empty already empty client cart.
     */
    public void testEmptyAlreadyEmptyClientCart() {
        // Arrange
        final EmptyClientCartService service = new EmptyClientCartService(client);

        // Act
        try {
            service.execute();
        } catch (UnknownUserException uue) {
            fail("Failed to find an existing client to empty it's cart");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
        }

        // Assert
        assertFalse("Did not correctly empty an already empty client's Open Cart",
                checkClientOpenCart(CLIENT_USERNAME));
    }

    /**
     * Test empty inexistent client cart.
     */
    public void testEmptyInexistentClientCart() {
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
        final EmptyClientCartService service = new EmptyClientCartService(fakeClient);

        // Act
        try {
            service.execute();
            fail("Sucessfully emptied a cart of a client that does not exist in the database");

            // Assert
        } catch (UnknownUserException uue) {
            assertTrue("Wrong parameter in exception", uue.getUser().getUsername() == fakeClientUsername);
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
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
