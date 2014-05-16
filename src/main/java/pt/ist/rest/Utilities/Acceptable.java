package pt.ist.rest.Utilities;

import pt.ist.rest.domain.Plate;

/**
 * The Interface Acceptable.
 */
public interface Acceptable {
    
    /**
     * Verify if the plate is acceptable or not.
     *
     * @param plate the plate to be verified
     * @return true, if the plate is acceptable by the type of search
     */
    boolean accept(Plate plate);
}
