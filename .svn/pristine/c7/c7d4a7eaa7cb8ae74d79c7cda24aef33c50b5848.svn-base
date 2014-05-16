package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Manager;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.exception.ManagerAlreadyExistsException;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class CreateNewManagerService.
 */
public final class CreateNewManagerService extends RestService {

    /**
     * The manager dto.
     */
    private SimpleManagerDto managerDto;

    /**
     * Instantiates a new creates the new manager service.
     * 
     * @param manager
     *            the manager
     */
    public CreateNewManagerService(SimpleManagerDto manager) {
        managerDto = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Manager manager = new Manager(managerDto.getUsername(),
                managerDto.getPassword(), managerDto.getName());
        try {
            portal.addUser(manager);
        } catch (IllegalArgumentException e) {
            throw new ManagerAlreadyExistsException(managerDto);
        }
    }

}
