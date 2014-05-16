package pt.ist.rest.domain;

import pt.ist.rest.domain.exception.OperationNotAllowedException;

/**
 * This class represents a closed Cart of a Client, this way it is possible to record what
 * a client has ordered and what did he pay.
 * 
 * @see Client
 * @see ShoppingCart
 */
public class ClosedCart extends
        ClosedCart_Base {

    public ClosedCart() {
        super();
    }

    /**
     * @param openCart Cart that is to be closed
     */
    public ClosedCart(OpenCart openCart) {
        super();
        super.setTotal(openCart.getTotal());
        for (PlateQuantity plate : openCart.getPlateQuantity()) {
            this.addPlateQuantity(plate);
        }
    }

    /**
     * Prevents the total cost of the Cart to be changed.
     *
     * @param total the new total
     */
    @Override
    public final void setTotal(final double total) {
        throw new OperationNotAllowedException("O valor final da compra nao pode ser mudado!");
    }

    @Override
    public void setClient(Client client) {
        client.addClientCartHistory(this);
    }

}
