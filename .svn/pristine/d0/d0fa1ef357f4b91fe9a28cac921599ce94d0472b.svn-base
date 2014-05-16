package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class UnknownRestaurantException.
 * 
 * Thrown when a restaurant does not exists on application database.
 */
public class UnknownRestaurantException extends RestaurantException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new unknown restaurant exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param restaurant
     *            The restaurant that caused the exception.
     */
    public UnknownRestaurantException(String message,
            SimpleRestaurantDto restaurant) {
        super(message, restaurant);
    }

    public UnknownRestaurantException(SimpleRestaurantDto restaurant) {
        super("O restaurante " + restaurant.getName() + " nao foi encontrado", restaurant);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.service.exception.RestaurantException#specificMessage
     * ()
     */
    @Override
    protected String specificMessage() {
        return restaurant.toString();
    }

}
