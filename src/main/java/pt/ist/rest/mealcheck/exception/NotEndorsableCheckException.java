package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class NotEndorsableCheckException.
 */
public class NotEndorsableCheckException
    extends Exception
{
    
    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 8966993677855012530L;
    
    /**
     * The check number.
     */
    private String checkNumber;

    /**
     * Instantiates a new not endorsable check exception.
     *
     * @param checkNumber the fault info
     */
    public NotEndorsableCheckException(String checkNumber) {
        super("The Check with the number " + checkNumber + " is not endorsable");
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

    public NotEndorsableCheckException() {
        super();
    }
}
