package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Restaurant;

/**
 * The Class MaxPlatesOnRestaurantException.
 */
public class MaxPlatesOnRestaurantException extends
        RestaurantException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1557670303773972235L;

    private final Restaurant restaurant;
    private final int maxPlates;

    /**
     * Instantiates a new max plates on restaurant exception.
     * 
     * @param restaurant the restaurant
     */
    public MaxPlatesOnRestaurantException(Restaurant restaurant) {
        super();
        this.restaurant = restaurant;
        this.maxPlates = -1;
    }

    /**
     * Instantiates a new max plates on restaurant exception.
     * 
     * @param restaurant the restaurant
     * @param maxPlates Maximum number of plates that a client can like
     */
    public MaxPlatesOnRestaurantException(Restaurant restaurant, int maxPlates) {
        super();
        this.restaurant = restaurant;
        this.maxPlates = maxPlates;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        if (this.maxPlates == -1)
            return String.format(
                    "O restaurante %s excedeu o numero maximo de prato que pode vender.",
                    this.restaurant.getName());
        else
            return String.format(
                    "O restaurante %s excedeu o numero maximo de prato que pode vender.%n"
                            + "(Numero maximo de pratos que o cliente pode gostar e %d)",
                    this.restaurant.getName(), this.maxPlates);
    }
}
