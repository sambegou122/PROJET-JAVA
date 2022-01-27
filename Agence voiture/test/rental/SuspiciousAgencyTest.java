package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SuspiciousAgencyTest {
    
    private SuspiciousRentalAgency sr1;
	private Vehicle v1;
	private Vehicle v2;
	private Client c1;
	private Client c2;

    @Before
	public void before(){
		this.sr1= new SuspiciousRentalAgency();
		this.c1 = new Client("client1", 20);
		this.c2 = new Client("client2", 30);
		this.v1 = new Vehicle("brand1", "model1", 2015, 100);
		this.v2 = new Vehicle("brand2", "model2", 2000, 200);
    }
    
    @Test 
    public void rentVehicleIncreasePriceTest() throws UnknownVehicleException, IllegalStateException{
        this.sr1.addVehicle(this.v1);
        assertTrue(this.sr1.getAllVehicles().contains(v1));
        assertEquals(110.0,this.sr1.rentVehicle(c1,v1),0.0001);
    }

    @Test 
    public void rentVehicleNormalPriceTest() throws UnknownVehicleException, IllegalStateException{
        this.sr1.addVehicle(this.v1);
        assertTrue(this.sr1.getAllVehicles().contains(v1));
        assertEquals(100.0,this.sr1.rentVehicle(c2,v1),0.0001);
    }



    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.ClientTest.class);
     }
}
