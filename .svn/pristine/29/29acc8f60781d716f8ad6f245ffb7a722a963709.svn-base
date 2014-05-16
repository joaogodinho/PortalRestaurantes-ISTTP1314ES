package pt.ist.rest.domain;

import java.util.ArrayList;
import java.util.List;

import pt.ist.rest.Utilities.Classification;
import pt.ist.rest.Utilities.Constants;
import pt.ist.rest.Utilities.exception.InvalidClassificationException;
import pt.ist.rest.domain.exception.ExpensivePlateException;
import pt.ist.rest.domain.exception.MaxPlatesOnRestaurantException;
import pt.ist.rest.domain.exception.OperationNotAllowedException;
import pt.ist.rest.domain.exception.PlateNotFoundException;

/**
 * The Class Restaurant.
 */
public class Restaurant extends
        Restaurant_Base
        implements Classification {
    /**
     * Restaurant constructor automatically generated. Don't use this constructor, give
     * preference to the following constructor: {link #Restaurant(String, String)}
     * 
     * @see Restaurant#Restaurant(String, String)
     */
    public Restaurant() {
        super();
    }

    /**
     * Restaurant constructor. Sets its name and address.
     * 
     * @param name Restaurant name.
     * @param address Restaurant address.
     */
    public Restaurant(String name, String address) {
        super();
        setName(name);
        setAddress(address);
    }

    /**
     * Adds a plate to the restaurant. Only a restaurant Manager have permission to do
     * this task. Restaurant must have an associated portal.
     * 
     * @param manager A restaurant manager.
     * @param plate A restaurant plate.
     */
    public void addAvailablePlate(Manager manager, Plate plate) {
        final boolean validManager = this.getManagerSet().contains(manager);
        if (validManager) {
            if (this.getAvailablePlateCount() < Constants.MAX_PLATES_IN_RESTAURANT) {
                double maxPrice = getPortal().getMaxPrice();
                if(plate.getPrice() <= maxPrice) {
                    super.addAvailablePlate(plate);
                } else {
                    throw new ExpensivePlateException(plate, maxPrice);
                }
            }
            else
                throw new MaxPlatesOnRestaurantException(this, Constants.MAX_PLATES_IN_RESTAURANT);
        } else {
            throw new OperationNotAllowedException(String.format(
                    "O gestor %s nao gere o Restaurante %s", manager.getName(), this.getName()));
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.rest.domain.Restaurant_Base#addAvailablePlate(pt.ist.rest.domain.Plate)
     */
    @Override
    public void addAvailablePlate(Plate plate) {
        throw new OperationNotAllowedException("So o gestor pode adicionar pratos!");
    }

    /**
     * Calculates restaurant classification. Restaurant classification is calculated
     * according the number of clients that liked a plate of that restaurant. Restaurants
     * only have a classification if there is three or more plates with classification
     * greater than 1.
     * 
     * @return Restaurant's classification.
     */
    public float calculateClassification() {
        float counter = 0;
        List<Plate> platesWithValidClassification = new ArrayList<Plate>();

        for (Plate plate : this.getAvailablePlate()) {
            if (plate.calculateClassification() >= 1) {
                platesWithValidClassification.add(plate);
            }
        }

        if (platesWithValidClassification.size() < Constants.MIN_NUM_LIKED_PLATES) {
            throw new InvalidClassificationException(this);
        }

        for (Plate plate : platesWithValidClassification) {
            counter += plate.calculateClassification();
        }
        return counter / this.getAvailablePlate().size();
    }

    /**
     * Gets the plate by Id.
     * 
     * @param plateId the plate name
     * @return the plate by Id
     */
    public Plate getPlateById(int plateId) {
        for (Plate plate : this.getAvailablePlate()) {
            if (plate.getId() == plateId) {
                return plate;
            }
        }
        throw new PlateNotFoundException(plateId);
    }

    /**
     * Gets the plate by name.
     * 
     * @param plateName the plate name
     * @return the plate by name
     */
    public Plate getPlateByName(String plateName) {
        for (Plate plate : this.getAvailablePlate()) {
            if (plate.getName().equals(plateName)) {
                return plate;
            }
        }
        throw new PlateNotFoundException(plateName);
    }

    /**
     * Gets plates by token.
     * 
     * @param token the plate token
     * @return the list of plates that match the token
     */
    public List<Plate> getPlatesByToken(String token) {
        List<Plate> matchingPlates = new ArrayList<Plate>();
        for (Plate plate : this.getAvailablePlate()) {
            if (plate.getName().contains(token)) {
                matchingPlates.add(plate);
            }
        }
        return matchingPlates;
    }

    /**
     * Gets the plate by name.
     * 
     * @param plateName the plate name
     * @return the plate by name
     */
    public boolean hasPlateByName(String plateName) {
        for (Plate plate : this.getAvailablePlate()) {
            if (plate.getName().equals(plateName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a available plate on the restaurant.
     * 
     * @param manager the manager of this restaurant
     * @param plate the plate to be removed
     */
    public void removeAvailablePlate(Manager manager, Plate plate) {
        if (this.hasAvailablePlate(plate)) {
            this.removeAvailablePlate(plate);
        } else {
            throw new PlateNotFoundException(plate.getName(), this);
        }
    }

    @Override
    public void setPortal(RestaurantPortal portal) {
        portal.addRestaurant(this);
    }

    /*
     * (non-Javadoc)
     * 
     * @see pt.ist.fenixframework.pstm.AbstractDomainObject#toString()
     */
    @Override
    public String toString() {
        return this.getName() + " " + this.getAddress();
    }
}
