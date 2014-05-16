package pt.ist.rest.service;

import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.Utilities.Acceptable;
import pt.ist.rest.Utilities.SearchByToken;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.RestaurantPortal;

/**
 * The Class SearchPlateByNameService.
 */
public final class SearchPlateByNameService extends
        SearchPlateService {

    /**
     * Instantiates a new search plate by name service.
     * 
     * @param token the plate name
     */
    public SearchPlateByNameService(String token) {
        super(token);
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.service.SearchPlateService#getMatchingPlates(java.lang.String)
     */
    @Override
    protected List<Plate> getMatchingPlates(String match) {
        RestaurantPortal portal = FenixFramework.getRoot();
        Acceptable searchByToken = new SearchByToken(match);
        return portal.searchPlates(searchByToken);
    }
}
