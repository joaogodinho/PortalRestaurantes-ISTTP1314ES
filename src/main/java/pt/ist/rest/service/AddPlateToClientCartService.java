package pt.ist.rest.service;


import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Client;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.PlateNotFoundException;
import pt.ist.rest.domain.exception.RestaurantNotFoundException;
import pt.ist.rest.domain.exception.UserNotFoundException;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleClientDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnableToRemoveUnexistentPlateException;
import pt.ist.rest.service.exception.UnknownPlateException;
import pt.ist.rest.service.exception.UnknownRestaurantException;
import pt.ist.rest.service.exception.UnknownUserException;

/**
 * The Class AddPlateToClientCartService.
 */
public final class AddPlateToClientCartService extends
        RestService {

    private SimpleClientDto clientDto;
    private PlateDto plateDto;
    private int quantity;

    public AddPlateToClientCartService(SimpleClientDto clientDto, PlateDto plateDto, int quantity) {
        this.clientDto = clientDto;
        this.plateDto = plateDto;
        this.quantity = quantity;
    }

    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        Restaurant restaurant = null;
        try {
            restaurant = portal.getRestaurantByName(this.plateDto.getRestaurantDto().getName());
        } catch (RestaurantNotFoundException e) {
            throw new UnknownRestaurantException(plateDto.getRestaurantDto());
        }

        Plate plate = null;

        try {
            plate = restaurant.getPlateById(this.plateDto.getId());
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
            client.addPlateToCart(plate, this.quantity);
        } catch (PlateNotFoundException e) {
            throw new UnableToRemoveUnexistentPlateException(plateDto);
        }
    }
}
