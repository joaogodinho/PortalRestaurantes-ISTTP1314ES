package pt.ist.rest.domain;

import pt.ist.rest.domain.exception.PlateNotFoundException;

/**
 * The Abstract Class ShoppingCart.
 */
public abstract class ShoppingCart extends
        ShoppingCart_Base {

    /**
     * Instantiates a new shopping cart.
     */
    public ShoppingCart() {
        super();
    }

    /**
     * Gets the total price of the cart.
     *
     * @return total price of the cart
     */
    public abstract double getTotal();
    
    /**
     * Checks for plate by ID.
     *
     * @param id the id
     * @return true, if plate exists
     */
    public boolean hasPlateQuantityById(int id) {
        for(PlateQuantity p : getPlateQuantitySet()) {
            int plateId = p.getPlate().getId(); 
            if(plateId == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the plate by ID.
     *
     * @param id the id of the plate
     * @return the plate with the given name
     */
    public PlateQuantity getPlateQuantityById(int id) {
        for(PlateQuantity p : getPlateQuantitySet()) {
            int plateId = p.getPlate().getId(); 
            if(plateId == id) {
                return p;
            }
        }
        throw new PlateNotFoundException(id);
    }
    
    /**
     * Checks for plate by name.
     *
     * @param name the name of the plate
     * @return true, if plate exists
     * @deprecated
     */
    public boolean hasPlateQuantityByName(String name) {
        for(PlateQuantity p : getPlateQuantitySet()) {
            String plateName = p.getPlate().getName(); 
            if(plateName.equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the plate by name.
     *
     * @param name the name of the plate
     * @return the plate with the given name
     * @deprecated
     */
    public PlateQuantity getPlateQuantityByName(String name) {
        for(PlateQuantity p : getPlateQuantitySet()) {
            String plateName = p.getPlate().getName(); 
            if(plateName.equals(name)) {
                return p;
            }
        }
        throw new PlateNotFoundException(name);
    }
}
