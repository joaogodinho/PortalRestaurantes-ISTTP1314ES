package pt.ist.rest.service.exception;

import pt.ist.rest.service.dto.UserDto;

/**
 * The Class UserException.
 * 
 * Thrown when a error happens with a user (client or manager).
 */
public class UserException extends ServiceException {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The user.
     */
    protected UserDto user;

    /**
     * Instantiates a new user exception.
     * 
     * @param message
     *            Specific message indicating the error when thrown.
     * @param user
     *            The user that caused the exception.
     */
    public UserException(String message, UserDto user) {
        super(message);
        this.user = user;
    }

    public UserException() {
        super();
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * pt.ist.rest.domain.service.exception.ServiceException#specificMessage()
     */
    @Override
    protected String specificMessage() {
        if(this.user == null)
            return "Nao existe informacao especifiva a disponibilizar";
        return user.toString();
    }

    public UserDto getUser() {
        return user;
    }

}
