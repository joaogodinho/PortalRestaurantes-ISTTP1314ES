package pt.ist.rest.service;

import java.util.ArrayList;
import java.util.List;

import pt.ist.fenixframework.FenixFramework;
import pt.ist.rest.domain.Plate;
import pt.ist.rest.domain.RestaurantPortal;
import pt.ist.rest.service.dto.PlateDto;
import pt.ist.rest.service.dto.RestaurantMenuDto;
import pt.ist.rest.service.dto.SimpleRestaurantDto;
import pt.ist.rest.service.exception.ServiceException;
import pt.ist.rest.service.exception.UnknownPlateException;

/**
 * The Class GetMenuService.
 */
public final class ListMenuService extends
        RestService {

    /** The restaurant dto. */
    private SimpleRestaurantDto restaurantDto;

    /** The result. */
    private RestaurantMenuDto result = null;

    /**
     * Instantiates a new list menu service.
     * 
     * @param restaurant the restaurant
     */
    public ListMenuService(SimpleRestaurantDto restaurant) {
        this.restaurantDto = restaurant;
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.service.RestService#dispatch()
     */
    @Override
    protected void dispatch() throws ServiceException {
        RestaurantPortal portal = FenixFramework.getRoot();

        List<PlateDto> restaurant = new ArrayList<PlateDto>();

        for (Plate p : portal.getRestaurantByName(this.restaurantDto.getName()).getAvailablePlate()) {
            PlateDto plateDto = new PlateDto(p.getId(), p.getName(), p.getType(), p.getCalories(),
                    p.getPrice(), this.restaurantDto);
            restaurant.add(plateDto);
        }

        result = new RestaurantMenuDto(this.restaurantDto.getName(),
                this.restaurantDto.getAddress(), restaurant);
    }

    /**
     * Gets the result.
     * 
     * @return the result
     */
    public RestaurantMenuDto getResult() {
        return result;
    }
    
    /**
     * Gets the plate by name.
     *
     * @param name the name
     * @return the plate by name
     * @throws UnknownPlateException the unknown plate exception
     */
    public PlateDto getPlateByName(String name) throws UnknownPlateException {
        for(PlateDto plate : this.getResult().getAvailablePlates()){
            if(plate.getName().equals(name))
                return plate;
        }
        
        throw new UnknownPlateException(name);
    }
}
