package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimplePlateDto;

/**
 * The Class UnknownPlateException.
 * 
 * Thrown when a plate does not exists on application database.
 */
public class UnknownPlateException extends PlateException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new unknown plate exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param plate
     *            The plate that caused this exception.
     */
    public UnknownPlateException(String message, SimplePlateDto plate) {
        super(message, plate);
    }
    
    /**
     * Instantiates a new unknown plate exception.
     *
     * @param plate the plate
     */
    public UnknownPlateException(SimplePlateDto plate) {
        super("Nao foi possivel localizar o prato com o nome " + plate.getName() + " no portal", plate);
    }

    /**
     * Instantiates a new unknown plate exception.
     *
     * @param plateName the plate name
     */
    public UnknownPlateException(String plateName) {
        super("Nao foi possivel localizar o prato com o nome " + plateName + " no portal", null);
    }
}
