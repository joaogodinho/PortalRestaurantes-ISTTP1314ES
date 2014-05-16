package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.exception.ClientAlreadyExistsException;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class CreateNewClientService.
 */
public final class CreateNewClientService extends RestService {

    /**
     * The client dto.
     */
    private final SimpleClientDto clientDto;

    /**
     * Instantiates a new creates the new client service.
     * 
     * @param client
     *            the client
     */
    public CreateNewClientService(SimpleClientDto client) {
        clientDto = client;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        Client client = new Client(clientDto.getUsername(),
                clientDto.getPassword(), clientDto.getName(),
                clientDto.getEmail(), clientDto.getAddress(),
                clientDto.getNif());

        try {
            portal.addUser(client);
        } catch (IllegalArgumentException e) {
            throw new ClientAlreadyExistsException(clientDto);
        }
    }

    /**
     * Gets the client dto.
     * 
     * @return the client dto
     */
    public SimpleClientDto getClientDto() {
        return clientDto;
    }

}
