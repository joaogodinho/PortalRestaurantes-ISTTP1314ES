package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;

/**
 * The Class ManagerAlreadyExistsException. Thrown when someone tries to add a manager to
 * a restaurant that already manages that restaurant.
 */
public class ManagerAlreadyInRestaurantException extends
        UserException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3263738902570422730L;

    /** The restaurant. */
    private final SimpleRestaurantDto restaurant;

    /**
     * Instantiates a new manager already exists exception.
     * 
     * @param message Specific message indicating the error when thrown.
     * @param restaurant The restaurant that caused the exception.
     * @param manager The manager that caused the exception.
     */
    public ManagerAlreadyInRestaurantException(String message,
                                               SimpleRestaurantDto restaurant,
                                               SimpleManagerDto manager) {
        super(message, manager);
        this.restaurant = restaurant;
    }

    public ManagerAlreadyInRestaurantException(SimpleRestaurantDto restaurant,
                                               SimpleManagerDto manager) {
        super("O gestor com o username " + manager.getUsername() + " ja existe no restaurante",
                manager);
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