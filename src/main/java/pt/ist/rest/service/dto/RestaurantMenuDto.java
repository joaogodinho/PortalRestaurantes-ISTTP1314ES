package pt.ist.rest.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class RestaurantMenuDto.
 */
public class RestaurantMenuDto extends
        SimpleRestaurantDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 548381498226786837L;

    /** The plate list. */
    private List<PlateDto> plateList;

    /**
     * Instantiates a new restaurant menu dto.
     * 
     * @param name the name of the restaurant
     * @param address the address of the restaurant
     * @param plateList the plate list corresponding to the restaurant
     */
    public RestaurantMenuDto(String name, String address, List<PlateDto> plateList) {
        super(name, address);
        List<PlateDto> copy = new ArrayList<PlateDto>();
        for (PlateDto plateDto : plateList) {
            copy.add(plateDto);
        }
        this.plateList = copy;
    }

    public RestaurantMenuDto() { }

    /**
     * Gets the available plates.
     * 
     * @return the available plates
     */
    public List<PlateDto> getAvailablePlates() {
        List<PlateDto> copy = new ArrayList<PlateDto>();
        for (PlateDto plateDto : this.plateList) {
            copy.add(plateDto);
        }
        return copy;
    }

    public boolean hasPlate(PlateDto plate) {
        for (PlateDto availablePlate : plateList)
            if (plate.getId() == availablePlate.getId())
                return true;

        return false;
    }
}
