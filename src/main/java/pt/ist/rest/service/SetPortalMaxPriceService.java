package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class GetMenuService.
 */
public final class SetPortalMaxPriceService extends
        RestService {

    /** The restaurant dto. */
    private double maxPrice;

    /**
     * Instantiates a new list menu service.
     *
     * @param maxPrice the max price
     */
    public SetPortalMaxPriceService(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        portal.setMaxPrice(maxPrice);
    }
}