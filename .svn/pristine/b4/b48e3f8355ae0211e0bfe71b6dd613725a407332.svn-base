package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Manager;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.ExpensivePlateException;
import pt.ist.rest.domain.exception.MaxPlatesOnRestaurantException;
import pt.ist.rest.domain.exception.OperationNotAllowedException;
import pt.ist.rest.domain.exception.RestaurantNotFoundException;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleManagerDto;
import pt.ist.rest.service.exception.ManagerNotInRestaurantException;
import pt.ist.rest.service.exception.PlateMaxPriceException;
import pt.ist.rest.service.exception.RestaurantMaxPlatesException;
import pt.ist.rest.service.exception.ServiceException;

/**
 * The Class CreateNewPlateService.
 */
public final class ManagerAddsNewPlateService extends
        RestService {

    /**
     * The manager dto.
     */
    private final SimpleManagerDto managerDto;

    /**
     * The plate dto.
     */
    private final PlateDto plateDto;

    /**
     * Instantiates a new creates the new plate service.
     * 
     * @param plate the plate
     * @param manager the manager
     */
    public ManagerAddsNewPlateService(PlateDto plate, SimpleManagerDto manager) {
        plateDto = plate;
        managerDto = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Plate plate = new Plate(plateDto.getName() , plateDto.getCalories(),
                plateDto.getPrice());
        Restaurant restaurant;
        try {
            restaurant = portal.getRestaurantByName(plateDto.getRestaurantDto().getName());
        } catch (RestaurantNotFoundException e) {
            throw new pt.ist.rest.service.exception.RestaurantNotFoundException(plateDto.getRestaurantDto().getName());
        }
        Manager manager = portal.getManagerByUsername(managerDto.getUsername());
        try {
            restaurant.addAvailablePlate(manager, plate);
        } catch (OperationNotAllowedException e) {
            throw new ManagerNotInRestaurantException(plateDto.getRestaurantDto(), managerDto);
        } catch (ExpensivePlateException e) {
            throw new PlateMaxPriceException(this.plateDto);
        } catch (MaxPlatesOnRestaurantException e) {
            throw new RestaurantMaxPlatesException(this.plateDto.getRestaurantDto());
        }
        this.plateDto.setId(plate.getId());
    }

}
