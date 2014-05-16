package pt.ist.rest.domain;

import pt.ist.rest.Utilities.Classification;
import pt.ist.rest.Utilities.FoodType;
import pt.ist.rest.domain.exception.OperationNotAllowedException;

/**
 * The Class Plate is to be used as an element in a Cart.
 * 
 * @see OpenCart
 */
public class Plate extends
        Plate_Base
        implements Classification {

    /**
     * Plate constructor automatically generated. Don't use this constructor, give
     * preference to the following constructor: Plate(String, String, double, double)
     * 
     * @see Plate#Plate(String, String, double, double)
     */
    public Plate() {
        super();
    }

    /**
     * Plate constructor. Sets its name, type, calories and price.
     * 
     * @param name Plate name.
     * @param calories Plate calories.
     * @param price Plate price.
     */
    public Plate(String name, double calories, double price) {
        super();
        super.setId(RestaurantPortal.generateID());
        setName(name);
        setCalories(calories);
        setPrice(price);
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Plate_Base#addClient(pt.ist.rest.domain.Client)
     */
    @Override
    public void addClient(Client client) {
        client.addLikedPlate(this);
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Plate_Base#addFood(pt.ist.rest.domain.Food)
     */
    @Override
    public void addFood(Food food) {
        for (Food existingFood : this.getFood()) {
            if (existingFood.getName().equals(food.getName()))
                return;
        }
        super.addFood(food);
        if (this.getType() == null)
            this.setType(food.getType());
        else if (FoodType.Vegetariano.toString().equals(this.getType()))
            this.setType(food.getType());

    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Plate_Base#addPlateQuantity(pt.ist.rest.domain.PlateQuantity)
     */
    @Override
    public void addPlateQuantity(PlateQuantity plateQuantity) {
        plateQuantity.setPlate(this);
    }

    /**
     * Calculates plate classification. Plate classification is calculated according the
     * number of Clients that liked that plate.
     * 
     * @return Plate classification.
     */
    public float calculateClassification() {
        return this.getClientCount();
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Plate_Base#setId(int)
     */
    @Override
    public void setId(int id) {
        throw new OperationNotAllowedException("Nao e permitido alterar o ID do prato");
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Plate_Base#setRestaurant(pt.ist.rest.domain.Restaurant)
     */
    @Override
    public void setRestaurant(Restaurant restaurant) {
        restaurant.addAvailablePlate(this);
    }

    /* (non-Javadoc)
     * @see pt.ist.fenixframework.pstm.AbstractDomainObject#toString()
     */
    @Override
    public String toString() {
        return String.format("%s, prato do tipo: %s, %.1fcal %.2f€", getName(), getType(),
                getCalories(), getPrice());
    }
}
