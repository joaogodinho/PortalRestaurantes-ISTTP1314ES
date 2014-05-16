package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.domain.Plate;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SearchPlatesDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class SearchPlateByNameService.
 */
public abstract class SearchPlateService extends
        RestService {

    /** The plate name. */
    private final String token;

    /** The result. */
    private SearchPlatesDto result = null;

    /**
     * Instantiates a new search plate by name service.
     * 
     * @param token the plate name
     */
    public SearchPlateService(String token) {
        super();
        this.token = token;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        List<Plate> matchingPlates = getMatchingPlates(this.token);
        List<PlateDto> matchingPlatesDto = new ArrayList<PlateDto>();
        for (Plate p : matchingPlates) {
            SimpleRestaurantDto restaurantDto = new SimpleRestaurantDto(
                    p.getRestaurant().getName(), p.getRestaurant().getAddress());
            matchingPlatesDto.add(new PlateDto(p.getId(), p.getName(), p.getType(), p.getCalories(),
                    p.getPrice(), restaurantDto));

        }
        this.result = new SearchPlatesDto(matchingPlatesDto);

    }
    
    protected abstract List<Plate> getMatchingPlates(String match);

    /**
     * Gets the result.
     * 
     * @return the list of plates which name contains the token
     */
    public SearchPlatesDto getResult() {
        return result;
    }
}
