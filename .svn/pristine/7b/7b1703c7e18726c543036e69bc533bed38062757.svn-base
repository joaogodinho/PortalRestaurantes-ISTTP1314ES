package pt.ist.rest.domain.exception;

import pt.ist.rest.domain.Plate;

/**
 * The Exception ExpensivePlateException.
 * 
 * This is thrown when a manager tries to add a plate with
 * a higher price than the allowed.
 */
public class ExpensivePlateException extends RestException {

    private static final long serialVersionUID = -6744912477265314421L;
    
    private final Plate plate;
    private final double maxPrice;

    public ExpensivePlateException(Plate plate, double maxPrice) {
        super();
        this.plate = plate;
        this.maxPrice = maxPrice;
    }

    /* (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public String getMessage() {
        return String.format(
                "O prato que pretende criar (%s, preco: %f) e' mais caro que o preco maximo %f",
                this.plate.getName(), this.plate.getPrice(), this.maxPrice);
    }

}
