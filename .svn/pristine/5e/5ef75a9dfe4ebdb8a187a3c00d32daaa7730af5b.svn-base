package pt.ist.rest.service;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Food;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.Restaurant;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.domain.exception.PlateNotFoundException;
import pt.ist.rest.domain.exception.RestaurantNotFoundException;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.SimpleFoodDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownPlateException;

/**
 * The Class CreateNewPlateService.
 */
public final class AddNewFoodToPlateService extends
        RestService {

    /**
     * The plate dto.
     */
    private final PlateDto plateDto;

    private final SimpleFoodDto foodDto;
    
    /**
     * Instantiates a new creates the new plate service.
     *
     * @param food the food
     * @param plate the plate
     */
    public AddNewFoodToPlateService(SimpleFoodDto food, PlateDto plate) {
        this.foodDto = food;
        this.plateDto = plate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();
        Restaurant restaurant;
        try {
            restaurant = portal.getRestaurantByName(plateDto.getRestaurantDto().getName());
        } catch (RestaurantNotFoundException e) {
            throw new pt.ist.rest.service.exception.RestaurantNotFoundException(plateDto.getRestaurantDto().getName());
        }
        Plate plate;
        try {
            plate = restaurant.getPlateById(this.plateDto.getId());
        } catch (PlateNotFoundException e) {
            throw new UnknownPlateException(plateDto);
        }
        Food food = new Food(this.foodDto.getName(), this.foodDto.getType());
        plate.addFood(food);
    }

}
