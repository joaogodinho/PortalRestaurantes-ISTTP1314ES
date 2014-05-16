package pt.ist.rest.domain.exception;

/**
 * This exception will be thrown when a restaurant is not found on the application.
 * 
 * @see Restaurant
 */
public class RestaurantNotFoundException extends
        RestaurantException {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2171130518783219747L;
    
    /** The restaurant name. */
    private final String restaurantName;

    /**
     * Instantiates a new restaurant not found exception.
     *
     * @param restaurantName the restaurant's name
     */
    public RestaurantNotFoundException(String restaurantName) {
        super();
        this.restaurantName = restaurantName;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format("O restaurante com o nome %s nao foi encontrado.", this.restaurantName);
    }
}
