package rental;

import java.util.*;
public class Car extends Vehicle {

    protected int nbpassenger;

        	/**
	 * creates a vehivle with given informations
	 * 
	 * @param brand
	 *            the vehicle's brand
	 * @param model
	 *            the vehicle's model
	 * @param productionYear
	 *            the vehicle's production year
	 * @param dailyRentalPrice
	 *            the daily rental price
     * @param nbpassenger
     *          the number of people that can take the car
	 */
    public Car(String brand, String model, int productionYear, float dailyRentalPrice, int nbpassenger){
        super(brand, model,productionYear,dailyRentalPrice);
        this.nbpassenger = nbpassenger;
    }
    /**
     * 
     * @return the car's number of people 
     */
    public int getNbpassenger(){
        return this.nbpassenger;
    }


    public String toString() {
        return super.toString()+" "+ this.nbpassenger;

    }
    
}
