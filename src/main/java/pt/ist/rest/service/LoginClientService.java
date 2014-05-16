package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.UserNotFoundException;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownUserException;
import pt.ist.rest.service.exception.WrongPasswordException;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginClientService.
 */
public class LoginClientService extends
        RestService {

    /**
     * The client dto.
     */
    private final UserDto userDto;
    
    /**
     * The result.
     */
    private SimpleClientDto result;

    /**
     * Instantiates a new login client service.
     *
     * @param userDto the client dto
     */
    public LoginClientService(UserDto userDto) {
        super();
        this.userDto = userDto;
        result = null;
    }

    /* (non-Javadoc)
     * @see pt.ist.rest.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        
        RestaurantPortal portal = FenixFramework.getRoot();
        Client client;
        try {
            client = portal.getClientByUsername(userDto.getUsername());
        } catch (UserNotFoundException e) {
            throw new UnknownUserException(userDto);
        }
        
        if (!client.confirmPassowrd(userDto.getPassword()))
            throw new WrongPasswordException(userDto.getPassword());
        
        result = new SimpleClientDto(client.getUsername(), client.getPassword(), client.getName(),
                client.getEmail(), client.getAddress(), client.getNif());
    }

    /**
     * Gets the result.
     *
     * @return the result
     */
    public SimpleClientDto getResult() {
        return result;
    }
}
