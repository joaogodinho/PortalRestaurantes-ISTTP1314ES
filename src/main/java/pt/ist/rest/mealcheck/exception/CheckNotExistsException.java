package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckNotExistsException.
 */
public class CheckNotExistsException extends
        Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5270346114569623397L;
    
    /**
     * The check number.
     */
    private String checkNumber;

    /**
     * Instantiates a new cheque inexistente_ exception.
     * 
     * @param checkNumber the fault info
     */
    public CheckNotExistsException(String checkNumber) {
        super("The check with the number " + checkNumber + " does not exist");
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

    public CheckNotExistsException() {
        super();
    }
}
