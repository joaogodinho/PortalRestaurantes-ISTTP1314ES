package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Client;

/**
 * This Exception is used to alert that a client has reached the maximum number of plates
 * that he can like.
 * 
 * @see Client
 */
public class MaxNumberOfPlatesException extends
        RestException {

    /** The client. */
    private final Client client;
    
    /** The max plates. */
    private final int maxPlates;

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1557670303773972235L;

    /**
     * Instantiates a new max number of plates exception.
     * 
     * @param client name of the client that reached the limit of liked plates
     */
    public MaxNumberOfPlatesException(Client client) {
        //        super(String.format("O cliente %s excedeu o numero maximo de prato que pode gostar.",
        //                client.getName()));
        super();
        this.client = client;
        this.maxPlates = -1;
    }

    /**
     * Instantiates a new max number of plates exception.
     * 
     * @param client name of the client that reached the limit of liked plates
     * @param maxPlates Maximum number of plates that a client can like
     */
    public MaxNumberOfPlatesException(Client client, int maxPlates) {
        //        super(String.format("O cliente %s excedeu o numero maximo de prato que pode gostar.%n"
        //                    + "(Numero maximo de pratos que o cliente pode gostar e %d)", 
        //                    client.getName(), maxPlates));
        super();
        this.client = client;
        this.maxPlates = maxPlates;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        if (this.maxPlates == -1)
            return String.format("O cliente %s excedeu o numero maximo de prato que pode gostar.",
                    this.client.getName());
        else
            return String.format("O cliente %s excedeu o numero maximo de prato que pode gostar.%n"
                    + "(Numero maximo de pratos que o cliente pode gostar e %d)",
                    this.client.getName(), this.maxPlates);
    }

}
