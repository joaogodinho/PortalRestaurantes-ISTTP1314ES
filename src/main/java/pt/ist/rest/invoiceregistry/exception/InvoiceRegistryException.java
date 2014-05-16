package pt.ist.rest.invoiceregistry.exception;

/**
 * The Class InvoiceRegistryException.
 */
public class InvoiceRegistryException extends Exception {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    public InvoiceRegistryException() {
    }
    
    public InvoiceRegistryException(String message) {
        super(message);
    }
    
}
