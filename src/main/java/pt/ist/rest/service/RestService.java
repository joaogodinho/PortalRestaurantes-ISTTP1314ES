package pt.ist.rest.service;

import pt.ist.rest.service.exception.ServiceException;
import jvstm.Atomic;

/**
 * The Class RestService.
 */
public abstract class RestService {

    /**
     * Execute.
     *
     * @throws ServiceException the service exception
     */
    @Atomic
    public void execute() throws ServiceException {
        dispatch();
    }

    /**
     * Dispatch method is to be used to implement
     * the mechanism to communicate with the Domain Layer.
     * @throws ServiceException the service exception
     */
    protected abstract void dispatch() throws ServiceException;
}
