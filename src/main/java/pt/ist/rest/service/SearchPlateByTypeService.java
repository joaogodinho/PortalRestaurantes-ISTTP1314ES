package pt.ist.rest.service;

import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.Utilities.Acceptable;
import pt.ist.rest.Utilities.FoodType;
import pt.ist.rest.Utilities.SearchByType;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.RestaurantPortal;

/**
 * The Class SearchPlateByNameService.
 */
public final class SearchPlateByTypeService extends
        SearchPlateService {

    /**
     * Instantiates a new search plate by name service.
     * 
     * @param type the type
     */
    public SearchPlateByTypeService(String type) {
        super(type);
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.service.SearchPlateService#getMatchingPlates(java.lang.String)
     */
    @Override
    protected List<Plate> getMatchingPlates(String match) {
        RestaurantPortal portal = FenixFramework.getRoot();
        Acceptable searchByType = new SearchByType(Enum.valueOf(FoodType.class, match));
        return portal.searchPlates(searchByType);
    }
}
