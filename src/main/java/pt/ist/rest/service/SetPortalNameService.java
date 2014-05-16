package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class GetMenuService.
 */
public final class SetPortalNameService extends
        RestService {

    /** The restaurant dto. */
    private String name;

    /**
     * Instantiates a new sets the portal name service.
     *
     * @param name the name
     */
    public SetPortalNameService(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        portal.setName(name);
    }
}