package pt.ist.rest.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ShoppingCartDto.
 */
public class ShoppingCartDto
        implements java.io.Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -6147017869659660173L;

    /**
     * The client credit.
     */
    private double clientCredit;

    /**
     * The plates on the cart.
     */
    protected List<PlateQuantityDto> platesOnCart;
    
    /**
     * The total.
     */
    private double total = 0;

    /**
     * Instantiates a new shopping cart dto.
     */
    public ShoppingCartDto() {
    }

    /**
     * Instantiates a new shopping cart dto.
     *
     * @param clientCredit the credit of the client that owns this shopping cart
     * @param total the total cost of all the plates in the order
     * @param platesOnCart the plates on cart
     */
    public ShoppingCartDto(double clientCredit, double total, List<PlateQuantityDto> platesOnCart) {
        this.clientCredit = clientCredit;
        this.total = total;
        List<PlateQuantityDto> copy = new ArrayList<PlateQuantityDto>();
        for (PlateQuantityDto plateQuatities : platesOnCart) 
            copy.add(plateQuatities);
        this.platesOnCart = copy;
    }

    /**
     * Gets the client credit.
     *
     * @return the clientCredit
     */
    public double getClientCredit() {
        return clientCredit;
    }

    /**
     * Gets the plate quantities.
     * 
     * @return the plate quantities
     */
    public List<PlateQuantityDto> getPlateQuantities() {
        List<PlateQuantityDto> copy = new ArrayList<PlateQuantityDto>();
        for (PlateQuantityDto plateQuatities : this.platesOnCart)
            copy.add(plateQuatities);
        return copy;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public double getTotal() {
        return total;
    }
}
