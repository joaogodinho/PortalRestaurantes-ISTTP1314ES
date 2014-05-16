package pt.ist.rest.domain;

/**
 * The Class OpenCart.
 */
public class OpenCart extends
        OpenCart_Base {

    /**
     * Instantiates a new open cart.
     */
    public OpenCart() {
        super();
    }

    /**
     * Gets the total.
     *
     * @return Value of the Open Cart at the moment the function is called
     */
    @Override
    public double getTotal() {
        double precoTotal = 0;
        for (PlateQuantity plateQ : this.getPlateQuantity()) {
            double precoPrato = plateQ.getPlate().getPrice();
            precoTotal += (double) plateQ.getQuantity() * precoPrato;
        }
        return precoTotal;
    }

    @Override
    public void setClient(Client client) {
        client.setOpenCart(this);
    }

}
