package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckAlreadyUsedException.
 */
public class CheckAlreadyUsedException extends
        Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -3981802646249644653L;
    
    /**
     * The check number.
     */
    private String checkNumber;

    /**
     * Instantiates a new check already used exception.
     * 
     * @param checkNumber the check number
     */
    public CheckAlreadyUsedException(String checkNumber) {
        super("Check already registered: " + checkNumber);
        this.checkNumber = checkNumber;
    }

    /**
     * Gets the check number.
     *
     * @return the check number
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    public CheckAlreadyUsedException() {
        super();
    }
}
