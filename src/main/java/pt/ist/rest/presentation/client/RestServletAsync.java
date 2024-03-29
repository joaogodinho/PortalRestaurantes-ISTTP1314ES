package pt.ist.rest.presentation.client;

import java.util.List;

import pt.ist.rest.service.dto.FaturaDto;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.PlateQuantityDto;
import pt.ist.rest.service.dto.RestaurantMenuDto;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.SearchPlatesDto;
import pt.ist.rest.service.dto.ShoppingCartDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.dto.UserDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface RestServletAsync {

    /**
     * Login.
     * 
     * @param user the user
     * @param callback the callback
     */
    void login(UserDto user, AsyncCallback<SimpleClientDto> callback);

    /**
     * Gets the restaurants.
     *
     * @param callback the callback
     * @return the restaurants
     */
    void getRestaurants(AsyncCallback<RestaurantsOnPortalDto> callback);

    /**
     * Gets the menu.
     *
     * @param restaurant the restaurant
     * @param callback the callback
     * @return the menu
     */
    void getMenu(SimpleRestaurantDto restaurant, AsyncCallback<RestaurantMenuDto> callback);
    
    /**
     * Search plates by type.
     *
     * @param type the type
     * @param callback the callback
     */
    void searchPlatesByType(String type, AsyncCallback<SearchPlatesDto> callback);

    /**
     * Adds the plate to cart.
     *
     * @param client the client
     * @param plate the plate
     * @param quant the quant
     * @param callback the callback
     */
    void addPlateToCart(SimpleClientDto client,
                        PlateDto plate,
                        int quant,
                        AsyncCallback<Void> callback);

    /**
     * Gets the open cart.
     *
     * @param activeClient the active client
     * @param callback the callback
     */
    void getOpenCart(SimpleClientDto activeClient, AsyncCallback<ShoppingCartDto> callback);

    /**
     * Confirm cart.
     * 
     * @param client the client
     * @param checks the checks
     * @param callback the callback
     */
    void confirmCart(SimpleClientDto client, List<String> checks, AsyncCallback<FaturaDto> callback);

    /**
     * Inits the server.
     *
     * @param client the client
     * @param plate the plate
     * @param callback the callback
     */
    void isPlateOnCart(SimpleClientDto client, PlateDto plate, AsyncCallback<Boolean> callback);
    
    /**
     * Inits the server.
     *
     * @param callback the callback
     */
    void initServer(AsyncCallback<Void> callback);

    /**
     * Search plates by name.
     *
     * @param name the name
     * @param callback the callback
     */
    void searchPlatesByName(String name, AsyncCallback<SearchPlatesDto> callback);
    
}
