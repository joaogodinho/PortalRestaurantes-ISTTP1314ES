package pt.ist.rest.service.dto;

/**
 * The Class ClientDto.
 */
public class SimpleClientDto extends UserDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 7738161700710299893L;

    /** The address. */
    private String address;

    /** The email. */
    private String email;

    /** The nif. */
    private int nif;

    /** The credit. */
    private double credit;

    /**
     * Instantiates a new client dto.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @param name
     *            the name
     * @param email
     *            the email
     * @param address
     *            the address
     * @param nif
     *            the nif
     * @param credits
     *            the credits
     */
    public SimpleClientDto(String username, String password, String name,
            String email, String address, int nif, int credits) {
        super(username, password, name);
        this.email = email;
        this.address = address;
        this.nif = nif;
        this.credit = credits;
    }

    /**
     * Instantiates a new client dto.
     * 
     * @param username
     *            the username
     * @param password
     *            the password
     * @param name
     *            the name
     * @param email
     *            the email
     * @param address
     *            the address
     * @param nif
     *            the nif
     */
    public SimpleClientDto(String username, String password, String name,
            String email, String address, int nif) {
        this(username, password, name, email, address, nif, 0);
    }
    
    public SimpleClientDto() { }

    /**
     * Gets the address.
     * 
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the nif.
     * 
     * @return the nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * Gets the credit.
     * 
     * @return the credit
     */
    public double getCredit() {
        return credit;
    }

    @Override
    public String toString() {
        return "Client: " + getUsername() + " | Nome: " + getName() + " | Morada: "
                        + getAddress() + " | Email: " + getEmail() + " | NIF: "
                        + getNif() + " | Creditos: " + getCredit();
    }

}
