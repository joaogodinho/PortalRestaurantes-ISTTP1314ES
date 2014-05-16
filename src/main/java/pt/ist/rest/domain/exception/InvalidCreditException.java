package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Client;

/**
 * The Class InvalidCreditException.
 */
public class InvalidCreditException extends
        RestException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -4584696343917134381L;

    private final Client client;
    private final double credit;

    public InvalidCreditException(Client client, double credit) {
        super();
        this.client = client;
        this.credit = credit;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format(
                "E impossivel mudar o credito do cliente com o nome %s para o valor %f",
                this.client.getName(), this.credit);
    }
}
