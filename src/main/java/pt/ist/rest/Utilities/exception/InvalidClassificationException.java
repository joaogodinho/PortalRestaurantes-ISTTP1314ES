package pt.ist.rest.Utilities.exception;

import pt.ist.rest.Utilities.Classification;

/**
 * The Class InvalidClassificationException
 * is a exception present to aid the implementation of the 
 * Classification Interface.
 */
public class InvalidClassificationException extends
        RuntimeException {
    
    /** The classification. */
    private final Classification classification;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -8759912278393307472L;

    /**
     * Instantiates a new invalid classification exception.
     *
     * @param classification the classification
     */
    public InvalidClassificationException(Classification classification) {
        super();
        this.classification = classification;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format("Nao foi possivel calcular a classificacao do objecto %s.", classification.getClass().getSimpleName());
    }

}
