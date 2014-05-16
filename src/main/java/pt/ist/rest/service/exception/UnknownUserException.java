package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.UserDto;

/**
 * The Class UnknownUserException.
 * 
 * Thrown when a user (client, manager) does not exists on application database.
 */
public class UnknownUserException extends UserException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    public UnknownUserException() {
    }

    /**
     * Instantiates a new unknown user exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param user
     *            The user that caused the exception.
     */
    public UnknownUserException(String message, UserDto user) {
        super(message, user);
    }

    public UnknownUserException(UserDto user) {
        super("Nao foi possivel encontrar o utilizador " + user.getUsername() + " no portal", user);
    }
    
    public UnknownUserException(String userName) {
        super("Nao foi possivel encontrar o utilizador " + userName + " no portal", null);
    }
}
