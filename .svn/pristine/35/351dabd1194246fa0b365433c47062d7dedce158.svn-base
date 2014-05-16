package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Restaurant;

/**
 * The Class PlateNotFoundException.
 */
public class PlateNotFoundException extends
        RestException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6359628094268978060L;

    /** The plate name. */
    private final String plateName;

    /** The restaurant. */
    private final Restaurant restaurant;

    private final Integer plateId;

    public PlateNotFoundException(int plateId) {
        this(null, null, plateId);
    }

    /**
     * Instantiates a new plate not found exception.
     * 
     * @param plateName the plate name
     */
    public PlateNotFoundException(String plateName) {
        this(plateName, null);
    }

    /**
     * Instantiates a new plate not found exception.
     * 
     * @param plateName the plate name
     * @param restaurant the restaurant
     */
    public PlateNotFoundException(String plateName, Restaurant restaurant) {
        this(plateName, restaurant, null);
    }

    protected PlateNotFoundException(String plateName, Restaurant restaurant, Integer plateId) {
        this.plateName = plateName;
        this.restaurant = restaurant;
        this.plateId = plateId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        if (this.plateName == null) {
            return String.format("O prato com o id %d nao foi encontrado", this.plateId);
        } else {
            if (this.restaurant == null) {
                return String.format("O prato com o nome %s nao foi encontrado", this.plateName);
            } else {
                return String.format(
                        "O prato com o nome %s nao foi encontrado no restaurante com o nome %s",
                        this.plateName, this.restaurant.getName());
            }
        }
    }
}
