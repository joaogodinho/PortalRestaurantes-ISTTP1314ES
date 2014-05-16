package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class UpdateClientCreditService.
 */
public class UpdateClientCreditService extends
        RestService {

    /** The clientDto. */
    private final SimpleClientDto clientDto;
    
    /** The new credit. */
    private final double credit;

    /**
     * Instantiates a new update clientDto credit service.
     *
     * @param clientDto the clientDto that will receive the credit update
     * @param credit the new credit to be changed
     */
    public UpdateClientCreditService(SimpleClientDto clientDto, double credit) {
        super();
        this.clientDto = clientDto;
        this.credit = credit;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Client client = portal.getClientByUsername(this.clientDto.getUsername());
        client.updateCredit(this.credit);
    }

}
