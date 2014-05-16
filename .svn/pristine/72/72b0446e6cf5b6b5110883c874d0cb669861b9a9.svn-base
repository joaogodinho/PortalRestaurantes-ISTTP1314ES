package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.MaxNumberOfPlatesException;
import pt.ist.rest.domain.exception.PlateNotFoundException;
import pt.ist.rest.domain.exception.RestaurantNotFoundException;
import pt.ist.rest.domain.exception.UserNotFoundException;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.InvalidLikeException;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownPlateException;
import pt.ist.rest.service.exception.UnknownRestaurantException;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class AddALikeToAPlateService.
 */
public final class AddALikeToAPlateService extends RestService {

    /**
     * The client dto.
     */
    private final SimpleClientDto clientDto;

    /**
     * The plate dto.
     */
    private final PlateDto plateDto;

    /**
     * Instantiates a new adds the a like to a plate service.
     * 
     * @param plate
     *            the plate
     * @param client
     *            the client
     */
    public AddALikeToAPlateService(PlateDto plate, SimpleClientDto client) {
        plateDto = plate;
        clientDto = client;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {

        RestaurantPortal portal = FenixFramework.getRoot();

        Restaurant restaurant = null;

        try {
            SimpleRestaurantDto restaurantDto = plateDto.getRestaurantDto();
            restaurant = portal.getRestaurantByName(restaurantDto.getName());
        } catch (RestaurantNotFoundException e) {
            throw new UnknownRestaurantException(
                    "Nao foi possivel localizar o restaurant na base de dados.",
                    plateDto.getRestaurantDto());
        }

        Plate plate = null;
        try {
            plate = restaurant.getPlateById(plateDto.getId());
        } catch (PlateNotFoundException e) {
            throw new UnknownPlateException(plateDto);
        }

        Client client = null;
        try {
            client = portal.getClientByUsername(clientDto.getUsername());
        } catch (UserNotFoundException e) {
            throw new UnknownUserException(clientDto);
        }

        try {
            client.addLikedPlate(plate);
        } catch (MaxNumberOfPlatesException e) {
            throw new InvalidLikeException(clientDto, plateDto);
        }
    }

    /**
     * Gets the client dto.
     * 
     * @return the client dto
     */
    public SimpleClientDto getClientDto() {
        return clientDto;
    }

    /**
     * Gets the plate dto.
     * 
     * @return the plate dto
     */
    public PlateDto getPlateDto() {
        return plateDto;
    }

}
