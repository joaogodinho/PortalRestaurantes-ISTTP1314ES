package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class RestaurantAlreadyExistException. Thrown when a restaurant already exists on
 * application database.
 */
public class RestaurantAlreadyExistException extends
        RestaurantException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    public RestaurantAlreadyExistException() {
    }

    /**
     * Instantiates a new restaurant already exist exception.
     * 
     * @param message Specific message indicating the error when thrown.
     * @param restaurant The restaurant that caused this exception.
     */
    public RestaurantAlreadyExistException(String message, SimpleRestaurantDto restaurant) {
        super(message, restaurant);
    }

    public RestaurantAlreadyExistException(SimpleRestaurantDto restaurant) {
        super("O restaurante com o nome " + restaurant.getName() + " ja existe no portal",
                restaurant);
    }
}
