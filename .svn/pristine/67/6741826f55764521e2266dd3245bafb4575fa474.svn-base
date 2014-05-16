package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class ManagerNotInRestaurantException.
 */
public class ManagerNotInRestaurantException extends
        UserException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3263738902570422730L;

    /** The restaurant. */
    private final SimpleRestaurantDto restaurant;

    /**
     * Instantiates a new manager not in restaurant exception.
     *
     * @param message the message
     * @param restaurant the restaurant
     * @param manager the manager
     */
    public ManagerNotInRestaurantException(String message,
                                           SimpleRestaurantDto restaurant,
                                           SimpleManagerDto manager) {
        super(message, manager);
        this.restaurant = restaurant;
    }

    /**
     * Instantiates a new manager not in restaurant exception.
     *
     * @param restaurant the restaurant
     * @param manager the manager
     */
    public ManagerNotInRestaurantException(SimpleRestaurantDto restaurant, SimpleManagerDto manager) {
        super("O gestor com o username " + manager.getUsername() + " nao gere o restaurante "
                + restaurant.getName(), manager);
        this.restaurant = restaurant;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    public String specificMessage() {
        return super.specificMessage() + ", restaurante: " + restaurant;
    }
}
