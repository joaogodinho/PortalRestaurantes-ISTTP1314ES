package pt.ist.rest.service.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class SearchPlatesDto.
 */
public class SearchPlatesDto
        implements java.io.Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5297586025577589065L;
    
    /** The plate list. */
    private List<PlateDto> plateList;

    /**
     * Instantiates a new search plates dto.
     *
     * @param plateList the plate list
     */
    public SearchPlatesDto(List<PlateDto> plateList) {
        List<PlateDto> copy = new ArrayList<PlateDto>();
        for (PlateDto plateDto : plateList) {
            copy.add(plateDto);
        }
        this.plateList = copy;
    }
    
    public SearchPlatesDto() {
        super();
        plateList = new ArrayList<>();
    }
    
    /**
     * Gets the matching plates.
     *
     * @return the matching plates
     */
    public List<PlateDto> getMatchingPlates() {
        List<PlateDto> copy = new ArrayList<PlateDto>();
        for(PlateDto plateDto: this.plateList) {
            copy.add(plateDto);
        }
        return copy;
    }
    
    /**
     * Checks for plate.
     *
     * @param plate the plate
     * @return true, if successful
     */
    public boolean hasPlate(PlateDto plate) {
        for (PlateDto availablePlate : plateList)
            if (plate.getId() == availablePlate.getId())
                return true;
        
        return false;
    }
}
