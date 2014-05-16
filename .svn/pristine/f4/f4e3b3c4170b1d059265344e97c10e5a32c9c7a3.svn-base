package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Client;

/**
 * The Class InvalidCreditException.
 */
public class NotEnoughCreditException extends
        RestException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -4584696343917134381L;

    private final Client client;
    private final double debit;

    public NotEnoughCreditException(Client client, double debit) {
        super();
        this.client = client;
        this.debit = debit;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format(
                "O Cliente com o nome %s nao tem credito suficiente para realizar a operacao.%n"
                        + "Credito Actual: %f | Debito proposto: %f", this.client.getName(),
                this.client.getCredit(), this.debit);
    }
}
