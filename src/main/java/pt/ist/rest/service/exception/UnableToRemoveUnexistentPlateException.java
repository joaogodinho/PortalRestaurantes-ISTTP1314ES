package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.SimplePlateDto;


/**
 * The Class UnableToRemoveUnexistentPlateException.
 */
public class UnableToRemoveUnexistentPlateException extends
        PlateException {


    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;


    /**
     * Instantiates a new unable to remove unexistent plate exception.
     *
     * @param message the message
     * @param plate the plate
     */
    public UnableToRemoveUnexistentPlateException(String message, SimplePlateDto plate) {
        super(message, plate);
    }
    
    public UnableToRemoveUnexistentPlateException(SimplePlateDto plate) {
        super("Nao e possivel remover um prato que ja nao existe no tabuleiro", plate);
    }
    
    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.exception.PlateException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        return this.plate.toString();
    }
}
