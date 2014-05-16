package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.RestaurantPortalDto;
import pt.ist.rest.service.exception.ServiceException;

public class GetPortalFaturaInfoService extends RestService {

    private static final long serialVersionUID = 176246150179114375L;
    
    private RestaurantPortalDto result;

    /**
     * Instantiates a new plate quantity dto.
     * 
     * @param plate the plate
     * @param quantity the quantity
     */
    public GetPortalFaturaInfoService() {
    }
    
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        result = new RestaurantPortalDto();
        result.setName(portal.getName());
        result.setNif(portal.getNif());
    }
    
    /**
     * Gets the result.
     *
     * @return the result
     */
    public RestaurantPortalDto getResult() {
        return result;
    }
}
