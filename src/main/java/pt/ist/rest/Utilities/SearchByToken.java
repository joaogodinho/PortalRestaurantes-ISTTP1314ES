package pt.ist.rest.Utilities;

import pt.ist.rest.domain.Plate;

/**
 * The Class SearchByType.
 */
public class SearchByToken
        implements Acceptable {

    /**
     * The token.
     */
    private final String token;

    /**
     * Instantiates a new search by token.
     *
     * @param token the token
     */
    public SearchByToken(String token) {
        this.token = token;
    }

    /**
     * Verify if the plate contains the given token.
     *
     * @param plate the plate to be verified
     * @return true, if the plate contains the given token
     */
    @Override
    public boolean accept(Plate plate) {
        return plate.getName().contains(this.token);
    }

}
