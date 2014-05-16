package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Manager;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.UserNotFoundException;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.RestaurantAlreadyExistException;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class CreateNewRestaurantService.
 */
public final class CreateNewRestaurantService extends RestService {

    /** The restaurant. */
    private final SimpleRestaurantDto restaurantDto;
    
    /** The manager dto. */
    private final SimpleManagerDto managerDto;

    /**
     * Instantiates a new creates the new restaurant service. Restaurant must be
     * at a coherent state, i.e. must have a manager (use the appropriate
     * restaurant constructor).
     *
     * @param restaurant            the restaurant
     * @param manager the manager
     */
    public CreateNewRestaurantService(SimpleRestaurantDto restaurant, SimpleManagerDto manager) {
        this.restaurantDto = restaurant;
        this.managerDto = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Restaurant restaurant = new Restaurant(restaurantDto.getName(),
                restaurantDto.getAddress());
        try {
            Manager manager = portal.getManagerByUsername(this.managerDto.getUsername());

            portal.addRestaurant(restaurant);
            
            restaurant.addManager(manager);
        } catch (IllegalArgumentException e) {
            throw new RestaurantAlreadyExistException(restaurantDto);
        } catch (UserNotFoundException e) {
            throw new UnknownUserException(this.managerDto);
        }
    }

}
