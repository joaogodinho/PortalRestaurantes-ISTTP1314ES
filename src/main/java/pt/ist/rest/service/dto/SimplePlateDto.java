package pt.ist.rest.service.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class SimplePlateDto.
 */
public class SimplePlateDto implements java.io.Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = -9028540478262406746L;

    /** The calories. */
    protected double calories;

    /**
     * The classification.
     */
    protected double classification;
    /**
     * The id.
     */
    protected int id;
    /** The name. */
    protected String name;
    /** The price. */
    protected double price;
    /** The type. */
    protected String type;

    /**
     * Instantiates a new simple plate dto.
     */
    public SimplePlateDto() { }

    /**
     * Instantiates a new simple plate dto.
     * 
     * @param id
     *            the id
     * @param name
     *            the name
     * @param type
     *            the type
     * @param calories
     *            the calories
     * @param price
     *            the price
     */
    public SimplePlateDto(int id, String name, String type, double calories,
            double price) {
        this(id, name, type, calories, price, 0);
    }

    /**
     * Instantiates a new simple plate dto.
     * 
     * @param id
     *            the id
     * @param name
     *            the name
     * @param type
     *            the type
     * @param calories
     *            the calories
     * @param price
     *            the price
     * @param classification
     *            the classification
     */
    public SimplePlateDto(int id, String name, String type, double calories,
            double price, double classification) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.price = price;
        this.classification = classification;
    }

    /**
     * Instantiates a new simple plate dto.
     * 
     * @param name
     *            the name
     * @param type
     *            the type
     * @param calories
     *            the calories
     * @param price
     *            the price
     */
    public SimplePlateDto(String name, String type, double calories,
            double price) {
        this(-1, name, type, calories, price, 0);
    }

    /**
     * Instantiates a new simple plate dto.
     * 
     * @param name
     *            the name
     * @param type
     *            the type
     * @param calories
     *            the calories
     * @param price
     *            the price
     * @param classification
     *            the classification
     */
    public SimplePlateDto(String name, String type, double calories,
            double price, double classification) {
        this(-1, name, type, calories, price, classification);
    }

    /**
     * Gets the calories.
     * 
     * @return the calories
     */
    public double getCalories() {
        return calories;
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
     * Gets the id.
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price.
     * 
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the type.
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name + ", calorias: " + calories + ", preco: " + price
                + ", classificacao: " + classification;
    }
}
