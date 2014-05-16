package pt.ist.rest.domain;

/**
 * The Class PlateQuantity 
 * represents the quantity of a plate to be put in a cart.
 * 
 * @see Plate
 * @see OpenCart
 */
public class PlateQuantity extends
        PlateQuantity_Base {

    /**
     * Instantiates a new plate quantity.
     * Not to be used, use instead {@link #PlateQuantity(Plate, int)}
     * 
     * @see PlateQuantity#PlateQuantity(Plate, int)
     */
    public PlateQuantity() {
        super();
    }

    /**
     * Instantiates a new plate quantity.
     *
     * @param plate the plate
     * @param quantity the quantity
     */
    public PlateQuantity(Plate plate, int quantity) {
        super();
        this.setPlate(plate);
        this.setQuantity(quantity);
    }

    @Override
    public void addShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.addPlateQuantity(this);
    }
}
