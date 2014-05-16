package pt.ist.rest.service.dto;

/**
 * The Class SimpleRestaurantDto.
 */
public class SimpleRestaurantDto
        implements java.io.Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 4118813878879270992L;

    /**
     * The address.
     */
    protected String address;
    /**
     * The classification.
     */
    protected double classification;
    /**
     * The name.
     */
    protected String name;

    public SimpleRestaurantDto(String name, String address) {
        this(name, address, 0);
    }

    public SimpleRestaurantDto(String name, String address, double classification) {
        this.name = name;
        this.address = address;
        this.classification = classification;
    }

    public SimpleRestaurantDto() { }
    
    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the classification.
     * 
     * @return the classification
     */
    public double getClassification() {
        return classification;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Restaurante: " + name + " | Morada: " + address + " Classificacao: " + classification;
    }
}
