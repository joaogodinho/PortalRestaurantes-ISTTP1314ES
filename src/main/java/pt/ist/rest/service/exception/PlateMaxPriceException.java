package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimplePlateDto;

/**
 * The Class PlateMaxPriceException.
 */
public class PlateMaxPriceException extends
        PlateException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7070943475390351153L;

    /**
     * Instantiates a new plate max price exception.
     *
     * @param message the message
     * @param plate the plate
     */
    public PlateMaxPriceException(String message, SimplePlateDto plate) {
        super(message, plate);
    }

    /**
     * Instantiates a new plate max price exception.
     *
     * @param plate the plate
     */
    public PlateMaxPriceException(SimplePlateDto plate) {
        super("O prato " + plate.getName() + " tem o preco demasiado elevado", plate);
    }
}
