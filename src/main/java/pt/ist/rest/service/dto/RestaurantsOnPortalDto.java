package pt.ist.rest.service.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Class RestaurantsRestaurantPortalDto.
 */
public class RestaurantsOnPortalDto extends
        RestaurantPortalDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The restaurant list. */
    private List<SimpleRestaurantDto> restaurants = new ArrayList<SimpleRestaurantDto>();

    /**
     * Instantiates a new restaurants restaurant portal dto.
     * 
     * @param restaurantList the restaurant list
     */
    public RestaurantsOnPortalDto(List<SimpleRestaurantDto> restaurantList) {
        for (SimpleRestaurantDto r : restaurantList) {
            this.restaurants.add(r);
        }
    }
    
    public RestaurantsOnPortalDto() { }

    /**
     * Gets the restaurants.
     * 
     * @return the restaurants
     */
    public Collection<SimpleRestaurantDto> getRestaurants() {
        Collection<SimpleRestaurantDto> listCopy = new ArrayList<SimpleRestaurantDto>();
        for (SimpleRestaurantDto r : this.restaurants) {
            listCopy.add(r);
        }
        return listCopy;
    }
}
