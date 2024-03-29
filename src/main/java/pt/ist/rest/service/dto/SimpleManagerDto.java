package pt.ist.rest.service.dto;

/**
 * The Class ManagerDto.
 */
public class SimpleManagerDto extends
        UserDto {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2100592609747631355L;
    
    /**
     * Instantiates a new manager dto.
     *
     * @param username the username
     * @param password the password
     * @param name the name
     */
    public SimpleManagerDto(String username, String password, String name) {
        super(username, password, name);
    }

    public SimpleManagerDto() { }
    
    /* (non-Javadoc)
     * @see pt.ist.rest.domain.service.dto.UserDto#toString()
     */
    @Override
    public String toString() {
        return String.format("Gestor: %s | Password: %s | Nome: %s", this.getUsername(), this.getPassword(), this.getName());
    }

}
