package pt.ist.rest.mealcheck.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class InvalidPayeeException.
 */
public class InvalidPayeeException extends
        Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4797596982741686786L;
    
    /**
     * The payee.
     */
    private String payee;

    /**
     * Instantiates a new invalid payee exception.
     * 
     * @param payee the payee
     */
    public InvalidPayeeException(String payee) {
        super("Invalid payee : " + payee);
        this.payee = payee;
    }
    
    /**
     * Gets the payee.
     *
     * @return the payee
     */
    public String getPayee() {
        return payee;
    }

    public InvalidPayeeException() {
        super();
    }
}
