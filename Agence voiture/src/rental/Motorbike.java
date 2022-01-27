package rental;

import java.util.*;

public class Motorbike extends Vehicle {

    protected float  cyl; //Attribut 

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
     * @param cyl_capacity 
     *          the Motorbike's cyl capacity
	 */

    public Motorbike(String brand, String model, int productionYear, float dailyRentalPrice, float cyl){
        super(brand, model,productionYear,dailyRentalPrice);
        this.cyl = cyl;

    }
    /**
     * return the cylinder capacity
     * @return MotorBike's cyl
     */
    public float getcyl(){
        return this.cyl;
    }


    public String toString() {
        return super.toString() + " " + this.cyl+ " cm³";

    }
    
}
