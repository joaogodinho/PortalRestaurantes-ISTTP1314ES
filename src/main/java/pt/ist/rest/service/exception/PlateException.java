package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimplePlateDto;

/**
 * The Class PlateException.
 * 
 * Thrown when some error related to a plate happens.
 */
public class PlateException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The plate.
     */
    protected final SimplePlateDto plate;
    
    /**
     * Instantiates a new plate exception.
     *
     * @param message Specific message indicating the error when thrown.
     * @param plate The plate that caused this exception.
     */
    public PlateException(String message, SimplePlateDto plate) {
        super(message);
        this.plate = plate;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        return "plate: " + plate;
    }

    public SimplePlateDto getPlate() {
        return plate;
    }

}
