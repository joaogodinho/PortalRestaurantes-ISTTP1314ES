package pt.ist.rest.presentation.client;

import java.util.List;

import pt.ist.rest.invoiceregistry.exception.InvoiceRegistryException;
import pt.ist.rest.mealcheck.exception.CheckAlreadyUsedException;
import pt.ist.rest.mealcheck.exception.CheckNotExistsException;
import pt.ist.rest.mealcheck.exception.InvalidCheckException;
import pt.ist.rest.mealcheck.exception.UserNotFoundException;
import pt.ist.rest.service.dto.FaturaDto;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.RestaurantMenuDto;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.SearchPlatesDto;
import pt.ist.rest.service.dto.ShoppingCartDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.exception.ServiceException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface RestServlet
        extends RemoteService {

    /**
     * Login.
     * 
     * @param user the user
     * @return the simple client dto
     * @throws ServiceException the service exception
     */
    SimpleClientDto login(UserDto user) throws ServiceException;

    /**
     * Gets the restaurants.
     * 
     * @return the restaurants
     * @throws ServiceException the service exception
     */
    RestaurantsOnPortalDto getRestaurants() throws ServiceException;

    /**
     * Gets the menu.
     * 
     * @param restaurant the restaurant
     * @return the menu
     * @throws ServiceException the service exception
     */
    RestaurantMenuDto getMenu(SimpleRestaurantDto restaurant) throws ServiceException;
    
    /**
     * Search plates by type.
     *
     * @param type the type
     * @return the search plates dto
     * @throws ServiceException the service exception
     */
    SearchPlatesDto searchPlatesByType(String type) throws ServiceException;
    
    /**
     * Search plates by name.
     *
     * @param name the name
     * @return the search plates dto
     * @throws ServiceException the service exception
     */
    SearchPlatesDto searchPlatesByName(String name) throws ServiceException;

    /**
     * Adds the plate to cart.
     *
     * @param client the client
     * @param plate the plate
     * @param quant the quant
     * @throws ServiceException the service exception
     */
    void addPlateToCart(SimpleClientDto client, PlateDto plate, int quant) throws ServiceException;

    /**
     * Gets the open cart.
     * 
     * @param client the client
     * @return the open cart
     * @throws ServiceException the service exception
     */
    ShoppingCartDto getOpenCart(SimpleClientDto client) throws ServiceException;

    /**
     * Confirm cart.
     *
     * @param client the client
     * @param checks the checks
     * @return the list
     * @throws InvalidCheckException the invalid check exception
     * @throws CheckAlreadyUsedException the check already used exception
     * @throws CheckNotExistsException the check not exists exception
     * @throws UserNotFoundException the user not found exception
     * @throws ServiceException the service exception
     * @throws InvoiceRegistryException the invoice registry exception
     */
    FaturaDto confirmCart(SimpleClientDto client, List<String> checks) throws InvalidCheckException,
            CheckAlreadyUsedException,
            CheckNotExistsException,
            UserNotFoundException,
            ServiceException,
            InvoiceRegistryException;

    /**
     * Checks if is plate on cart.
     *
     * @param client the client
     * @param plate the plate
     * @return the boolean
     * @throws ServiceException 
     */
    Boolean isPlateOnCart(SimpleClientDto client, PlateDto plate) throws ServiceException;
    
    /**
     * Inits the server.
     */
    void initServer();
    
}
