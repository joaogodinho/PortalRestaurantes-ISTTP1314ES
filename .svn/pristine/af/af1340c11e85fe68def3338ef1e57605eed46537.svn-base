package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.UserDto;

/**
 * The Class ClientAlreadyExistsException.
 * 
 * Thrown when a cliente already exists on application database.
 */
public class ClientAlreadyExistsException extends UserException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new client already exists exception.
     */
    public ClientAlreadyExistsException() {
    }

    /**
     * Instantiates a new client already exists exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param user
     *            The client that caused the exception.
     */
    public ClientAlreadyExistsException(String message, UserDto user) {
        super(message, user);
    }

    /**
     * Instantiates a new client already exists exception.
     *
     * @param user            The client that caused the exception.
     */
    public ClientAlreadyExistsException(UserDto user) {
        super("O cliente com o username " + user.getUsername() + " ja existe na base de dados.", user);
    }

}
