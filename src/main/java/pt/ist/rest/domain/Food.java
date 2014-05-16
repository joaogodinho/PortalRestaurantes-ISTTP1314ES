package pt.ist.rest.domain;

import pt.ist.rest.Utilities.FoodType;

/**
 * The Class Food.
 */
public class Food extends
        Food_Base {

    /**
     * Instantiates a new food.
     */
    public Food() {
        super();
    }

    /**
     * Instantiates a new food.
     *
     * @param name the name of the food
     * @param type the type of the food
     */
    public Food(String name, FoodType type) {
        super();
        this.setName(name);
        this.setType(type.toString());
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.Food_Base#setPlate(pt.ist.rest.domain.Plate)
     */
    @Override
    public void setPlate(Plate plate) {
        plate.addFood(this);
    }
}
