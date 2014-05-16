package pt.ist.rest.service.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Class RestaurantPortalDto.
 */
public class UsersRestaurantPortalDto extends RestaurantPortalDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The user list. */
    private final List<UserDto> users;

    /**
     * Instantiates a new users restaurant portal dto.
     * 
     * @param userList
     *            the user list
     */
    public UsersRestaurantPortalDto(List<UserDto> userList) {
        List<UserDto> copy = new ArrayList<UserDto>();
        for (UserDto u : userList) {
            copy.add(u);
        }
        this.users = copy;
    }

    public UsersRestaurantPortalDto() { 
        super();
        users = new ArrayList<>();
    }
    
    /**
     * Gets the users.
     * 
     * @return the users
     */
    public Collection<UserDto> getUsers() {
        Collection<UserDto> listCopy = new ArrayList<UserDto>();
        for (UserDto user : this.users) {
            listCopy.add(user);
        }
        return listCopy;
    }
}
