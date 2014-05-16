package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.User;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.dto.UserDto;
import pt.ist.rest.service.dto.UsersRestaurantPortalDto;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class ListUsersService.
 */
public final class ListUsersService extends
        RestService {

    /** The result. */
    private UsersRestaurantPortalDto result = null;

    /** The clients. */
    private Map<String, SimpleClientDto> clients = new HashMap<String, SimpleClientDto>();

    /** The managers. */
    private Map<String, SimpleManagerDto> managers = new HashMap<String, SimpleManagerDto>();

    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() {
        RestaurantPortal portal = FenixFramework.getRoot();

        List<UserDto> userList = new ArrayList<UserDto>();

        for (User u : portal.getUserSet()) {
            if (u instanceof Client) {
                SimpleClientDto client = new SimpleClientDto(u.getUsername(), u.getPassword(),
                        u.getName(), ((Client) u).getEmail(), ((Client) u).getAddress(),
                        ((Client) u).getNif());
                clients.put(u.getUsername(), client);
                userList.add(client);
            } else {
                SimpleManagerDto manager = new SimpleManagerDto(u.getUsername(), u.getPassword(),
                        u.getName());
                managers.put(u.getUsername(), manager);
                userList.add(manager);
            }
        }
        result = new UsersRestaurantPortalDto(userList);
    }

    /**
     * Gets the result.
     * 
     * @return Result that has in it a list of Users
     */
    public UsersRestaurantPortalDto getResult() {
        return result;
    }

    /**
     * Gets the client by username.
     * 
     * @param username the username
     * @return the client by username
     * @throws UnknownUserException the unknown user exception
     */
    public SimpleClientDto getClientByUsername(String username) throws UnknownUserException {
        SimpleClientDto client = clients.get(username);
        if (client == null)
            throw new UnknownUserException(username);
        return client;
    }

    /**
     * Gets the manager by username.
     * 
     * @param username the username
     * @return the manager by username
     * @throws UnknownUserException the unknown user exception
     */
    public SimpleManagerDto getManagerByUsername(String username) throws UnknownUserException {
        SimpleManagerDto manager = managers.get(username);
        if (manager == null)
            throw new UnknownUserException(username);
        return manager;
    }
}