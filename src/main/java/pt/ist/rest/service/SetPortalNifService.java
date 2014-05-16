package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class GetMenuService.
 */
public final class SetPortalNifService extends
        RestService {

    /** The restaurant dto. */
    private int nif;

    /**
     * Instantiates a new list menu service.
     *
     * @param nif the max price
     */
    public SetPortalNifService(int nif) {
        this.nif = nif;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        portal.setNif(nif);
    }
}