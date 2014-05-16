package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.UserDto;

/**
 * The Class InsufficientCreditsException.
 */
public class InsufficientCreditsException extends
        UserException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    public InsufficientCreditsException() {
    }

    /**
     * Instantiates a new insufficient credits exception.
     * 
     * @param message the message
     * @param user the user
     */
    public InsufficientCreditsException(String message, UserDto user) {
        super(message, user);
    }

    public InsufficientCreditsException(UserDto user) {
        super("O cliente com o username " + user.getUsername()
                + " nao tem creditos suficientes para efectuar a compra", user);
    }
}
