package pt.ist.rest.domain.service.test;

import pt.ist.rest.service.SearchPlateByNameService;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SearchPlatesDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.UnknownRestaurantException;

/**
 * The Class SearchPlateByNameServiceTest.
 */
public class SearchPlateByNameServiceTest extends
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
    private static final String SECOND_PLATE_NAME = "Bacalhau com Natas";

    /** The Constant SECOND_PLATE_TYPE. */
    private static final String SECOND_PLATE_TYPE = "Peixe";

    /** The Constant SECOND_PLATE_CALORIES. */
    private static final double SECOND_PLATE_CALORIES = 500;

    /** The Constant SECOND_PLATE_PRICE. */
    private static final double SECOND_PLATE_PRICE = 7;


    /** The restaurant. */
    private SimpleRestaurantDto restaurant;


    /** The manager. */
    private SimpleManagerDto manager;

    private PlateDto firstPlate;
    private PlateDto secondPlate;

    /**
     * Instantiates a new adds the plate to client cart service test.
     */
    public SearchPlateByNameServiceTest() {
        super();
    }

    /**
     * Instantiates a new adds the plate to client cart service test.
     * 
     * @param msg the msg
     */
    public SearchPlateByNameServiceTest(String msg) {
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
    }

    public void testSearchForPlateWithFullName() {
        // Arrange
        final String search = FIRST_PLATE_NAME;
        final SearchPlateByNameService service = new SearchPlateByNameService(search);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existent restaurant to search");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
        }

        // Assert
        final SearchPlatesDto result = service.getResult();
        assertNotNull("Did not realize any search after calling execute()", result);

        assertTrue("Did not find the plate when searching for it using it's full name",
                result.hasPlate(firstPlate));

        assertTrue("Found more plates than expected when searching using the full name", result
                .getMatchingPlates().size() == 1);
    }

    public void testSearchForPlateWithPartOfName() {
        // Arrange
        final String[] tokens = FIRST_PLATE_NAME.split(" ");
        final String search = tokens[tokens.length - 1];
        final SearchPlateByNameService service = new SearchPlateByNameService(search);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existent restaurant to search");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
        }

        // Assert
        final SearchPlatesDto result = service.getResult();
        assertNotNull("Did not realize any search after calling execute()", result);

        assertTrue("Did not find the plate when searching for it using part of it's name",
                result.hasPlate(firstPlate));

        assertTrue("Found more plates than expected when searching using part of it's name", result
                .getMatchingPlates().size() == 1);
    }

    public void testSearchForPlateThatYieldsMultipleResults() {
        // Arrange
        final String[] tokens = FIRST_PLATE_NAME.split(" ");
        final String search = tokens[0];
        final SearchPlateByNameService service = new SearchPlateByNameService(search);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existent restaurant to search");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to to empty a client's Open Cart");
        }

        // Assert
        final SearchPlatesDto result = service.getResult();
        assertNotNull("Did not realize any search after calling execute()", result);

        assertTrue("Did not find a valid plate when searching for it using part of it's name",
                result.hasPlate(firstPlate) && result.hasPlate(secondPlate));

        assertTrue("Found more plates than expected when searching using part of it's name", result
                .getMatchingPlates().size() == 2);
    }

    public void testSearchForPlateThatDoesNotExist() {
        // Arrange
        final String search = "Bitoque";
        final SearchPlateByNameService service = new SearchPlateByNameService(search);

        // Act
        try {
            service.execute();
        } catch (UnknownRestaurantException ure) {
            fail("Failed to find an existent restaurant to search");
        } catch (Exception e) {
            fail("Unexpected exception thrown while trying to search for a plate by name");
        }


        // Assert
        final SearchPlatesDto result = service.getResult();
        assertNotNull("Did not realize any search after calling execute()", result);

        assertFalse("Found plates that do not exist when searching for plates that do not exist",
                result.getMatchingPlates().size() > 0);
    }

//    public void testSearchForPlateInAnInexistentRestaurant() {
//        // Arrange
//        final String fakeRestaurantName = "Barriga Feliz";
//        final String fakeRestaurantAddress = "Porto, Portugal";
//        final SimpleRestaurantDto fakeRestaurant = new SimpleRestaurantDto(fakeRestaurantName,
//                fakeRestaurantAddress);
//
//        final String search = FIRST_PLATE_NAME;
//        final SearchPlateByNameService service = new SearchPlateByNameService(fakeRestaurant,
//                search);
//
//        // Act
//        try {
//            service.execute();
//            fail("Successfully realized a search on a restaurant that does not exist in the database");
//
//            // Assert
//        } catch (UnknownRestaurantException ure) {
//            assertTrue("Wrong parameter in exception", ure.getRestaurant().getName() == fakeRestaurantName);
//        } catch (Exception e) {
//            fail("Unexpected exception thrown while trying to search for a plate by name");
//        }
//    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.test.RestServiceTest#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        restaurant = null;
        manager = null;
        firstPlate = null;
        secondPlate = null;
    }

}
