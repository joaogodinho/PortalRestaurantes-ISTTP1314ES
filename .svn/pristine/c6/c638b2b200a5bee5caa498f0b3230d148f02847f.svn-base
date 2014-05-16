package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidCheckException.
 */
public class InvalidCheckException extends
        Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 7807288893344846613L;

    /**
     * The check number.
     */
    private String checkNumber;

    /**
     * Instantiates a new invalid check exception.
     * 
     * @param checkNumber the check number
     */
    public InvalidCheckException(String checkNumber) {
        super("Invalid check number: " + checkNumber);
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

    public InvalidCheckException() {
        super();
    }
}
