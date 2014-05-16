package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.OpenCart;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.PlateNotFoundException;
import pt.ist.rest.domain.exception.UserNotFoundException;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimplePlateDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class VerifyPlateOnCartService.
 * 
 * Verifies if a plate is on client cart.
 */
public class VerifyPlateOnCartService extends RestService {

    private boolean isPlateOnCart;
    private final SimplePlateDto plate;
    private final SimpleClientDto client;
    
    public VerifyPlateOnCartService(SimpleClientDto client, SimplePlateDto plate) {
        this.plate = plate;
        this.client = client;
    }
    
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Client clientDomain = null;
        try {
            clientDomain = portal.getClientByUsername(client.getUsername());
        } catch(UserNotFoundException e) {
            throw new UnknownUserException(client);
        }
        OpenCart openCart = clientDomain.getOpenCart();
        if(openCart == null) {
            isPlateOnCart = false;
            return;
        }
        try {
            openCart.getPlateQuantityById(plate.getId());
            isPlateOnCart = true;
        } catch(PlateNotFoundException e) {
            isPlateOnCart = false;
        }
    }
    
    public boolean getResult() {
        return isPlateOnCart;
    }

}
