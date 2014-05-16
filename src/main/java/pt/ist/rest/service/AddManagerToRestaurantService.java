package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class AddManagerToRestaurantService.
 */
public class AddManagerToRestaurantService extends RestService {
    /** The manager dto. */
    private final SimpleManagerDto managerDto;
    
    /** The restaurant dto. */
    private final SimpleRestaurantDto restaurantDto;

    /**
     * Instantiates a new adds the manager to restaurant service.
     *
     * @param managerDto the manager dto
     * @param restaurantDto the restaurant dto
     */
    public AddManagerToRestaurantService(SimpleManagerDto managerDto, SimpleRestaurantDto restaurantDto) {
        this.managerDto = managerDto;
        this.restaurantDto = restaurantDto;
    }
    
    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() {
        RestaurantPortal portal = FenixFramework.getRoot();
        Restaurant restaurant = portal.getRestaurantByName(restaurantDto.getName());
        restaurant.addManager(portal.getManagerByUsername(managerDto.getUsername()));
    }
}
