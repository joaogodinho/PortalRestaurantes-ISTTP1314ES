package pt.ist.rest.service.exception;

/**
 * The Class RestaurantAlreadyExistException.
 * 
 * Thrown when a restaurant already exists on application database.
 */
public class RestaurantNotFoundException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    
    /** The rest name. */
    private String restName;

    
    public RestaurantNotFoundException() {
        super();
    }
    
    /**
     * Instantiates a new restaurant already exist exception.
     *
     * @param restaurant            The restaurant that caused this exception.
     */
    public RestaurantNotFoundException(String restaurant) {
        super("O Restaurante nao foi encontrado");
        this.restName = restaurant;
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
        return "Nao existe um restaurante com o nome " + this.restName;
    }
}
