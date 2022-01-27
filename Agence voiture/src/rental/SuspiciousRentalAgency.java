
package rental;

public class SuspiciousRentalAgency extends RentalAgency {


    public SuspiciousRentalAgency(){
        super();
    }

    /** client rents a vehicle 
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price for client for vehicle v
    * @exception UnknownVehicleException   if v is not a vehicle of this agency  
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
        if(client.getAge()< 25){
            return super.rentVehicle(client, v)*(1.10f);
        }
        return super.rentVehicle(client, v);
    }
    
}
