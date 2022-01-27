package rental;

import java.util.*;

/**
 * An AndFilter performs the intersection of filters. It accepts a vehicle if
 * each of its filter accepts it.
 */
public class AndFilter implements VehicleFilter {

   private List<VehicleFilter> theFilters;

   /** creates an InterFilter with no filter */
   public AndFilter() {
      this.theFilters = new ArrayList<VehicleFilter>();
   }

   /**
    * @return Vehicle Filter's List
    */
   public List<VehicleFilter> getVehicleFilter(){
      return this.theFilters;
   }
   /**
    * adds a new filter
    * 
    * @param f the added filter
    */
   public void addFilter(VehicleFilter f) {
      theFilters.add(f);
   }

   /**
    * Accept the vehicle if each of its filters accepts it
    * 
    * @see VehicleFilter#accept(Vehicle)
    * @param v 
    * @return True if v accepted by theFilters else false
    */
   public boolean accept(Vehicle v) {
      for (VehicleFilter vehicleFilter : theFilters) {
         if(!vehicleFilter.accept(v)){
            return false;
         }
         
      }
      return true;
   }
}
