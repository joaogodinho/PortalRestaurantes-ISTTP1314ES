package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.Utilities.exception.InvalidClassificationException;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.RestaurantsOnPortalDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.RestaurantNotFoundException;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class GetRestaurantsService.
 */
public final class ListRestaurantsService extends
        RestService {

    /** The result. */
    private RestaurantsOnPortalDto result = null;

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        List<SimpleRestaurantDto> restaurants = new ArrayList<SimpleRestaurantDto>();

        for (Restaurant r : portal.getRestaurant()) {
            SimpleRestaurantDto restaurantDto;
            try {
                restaurantDto = new SimpleRestaurantDto(r.getName(), r.getAddress(),
                        r.calculateClassification());
            } catch (InvalidClassificationException e) {
                restaurantDto = new SimpleRestaurantDto(r.getName(), r.getAddress());
            }
            if (restaurantDto != null)
                restaurants.add(restaurantDto);
        }

        result = new RestaurantsOnPortalDto(restaurants);
    }

    /**
     * Gets the result.
     * 
     * @return Result that has in it a list of restaurants
     */
    public RestaurantsOnPortalDto getResult() {
        return result;
    }

    public SimpleRestaurantDto getRestaurantByName(String name) throws RestaurantNotFoundException {
        for (SimpleRestaurantDto restaurant : this.getResult().getRestaurants()) {
            if (restaurant.getName().equals(name))
                return restaurant;
        }
        throw new RestaurantNotFoundException(name);
    }

}
