package pt.ist.rest.Utilities;

import pt.ist.rest.domain.Plate;

/**
 * The Class SearchByType.
 */
public class SearchByType
        implements Acceptable {

    /**
     * The type.
     */
    private final FoodType type;

    /**
     * Instantiates a new search by type.
     * 
     * @param type the type
     */
    public SearchByType(FoodType type) {
        this.type = type;
    }

    /**
     * Verify if the plate contains the given type.
     * 
     * @param plate the plate to be verified
     * @return true, if the plate contains the given type
     */
    @Override
    public boolean accept(Plate plate) {
        return this.type.toString().equals(plate.getType());
    }

}
