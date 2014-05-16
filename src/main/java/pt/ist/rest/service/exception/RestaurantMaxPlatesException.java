package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class RestaurantMaxPlatesException.
 */
public class RestaurantMaxPlatesException extends
        RestaurantException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new restaurant max plates exception.
     */
    public RestaurantMaxPlatesException() {
    }

    /**
     * Instantiates a new restaurant max plates exception.
     *
     * @param message the message
     * @param restaurant the restaurant
     */
    public RestaurantMaxPlatesException(String message, SimpleRestaurantDto restaurant) {
        super(message, restaurant);
    }

    /**
     * Instantiates a new restaurant max plates exception.
     *
     * @param restaurant the restaurant
     */
    public RestaurantMaxPlatesException(SimpleRestaurantDto restaurant) {
        super("O restaurante com o nome " + restaurant.getName() + " alcancou o numero maximo de pratos",
                restaurant);
    }
}
