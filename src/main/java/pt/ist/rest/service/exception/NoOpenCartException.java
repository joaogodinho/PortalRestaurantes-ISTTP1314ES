package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.UserDto;

/**
 * The Class NoOpenCartException.
 */
public class NoOpenCartException extends
        UserException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new no open cart exception.
     */
    public NoOpenCartException() {
    }

    /**
     * Instantiates a new no open cart exception.
     * 
     * @param message the message
     * @param user the user
     */
    public NoOpenCartException(String message, UserDto user) {
        super(message, user);
    }

    /**
     * Instantiates a new no open cart exception.
     *
     * @param user the user
     */
    public NoOpenCartException(UserDto user) {

        super("O utilizador " + user.getUsername() + " nao tem um tabuleiro aberto", user);
    }

}
