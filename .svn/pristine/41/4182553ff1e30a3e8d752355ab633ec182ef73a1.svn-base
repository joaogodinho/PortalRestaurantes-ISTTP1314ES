package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class RestaurantException.
 * 
 * Saves a SimpleRestaurantDto when instantiated, exceptions that extends this
 * will be related to a restaurant.
 */
public class RestaurantException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The restaurant.
     */
    protected SimpleRestaurantDto restaurant;

    
    public RestaurantException() {
    }
    /**
     * Instantiates a new restaurant exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param restaurant
     *            The restaurant that caused the exception.
     */
    public RestaurantException(String message, SimpleRestaurantDto restaurant) {
        super(message);
        this.restaurant = restaurant;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        return "restaurante: " + restaurant;
    }

    public SimpleRestaurantDto getRestaurant() {
        return restaurant;
    }

}
