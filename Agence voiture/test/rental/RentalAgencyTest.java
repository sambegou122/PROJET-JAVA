package rental;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest {

	private RentalAgency r1;
	private Vehicle v1;
	private Vehicle v2;
	private Client c1;
	private Client c2;
	private VehicleFilter brandFilter;

	@Before
	public void before(){
		this.r1= new RentalAgency();
		this.c1 = new Client("client1", 20);
		this.c2 = new Client("client2", 30);
		this.v1 = new Vehicle("brand1", "model1", 2015, 100);
		this.v2 = new Vehicle("brand2", "model2", 2000, 200);
		this.brandFilter = new BrandFilter("brand1");
	}



	@Test
	public void getAllVehiclesTest(){
		List <Vehicle> test = new ArrayList<>();
		test.add(this.v1);
		test.add(this.v2);
		this.r1.addVehicle(this.v1);
		this.r1.addVehicle(this.v2);
		assertEquals(this.r1.getAllVehicles(),test);
	}

	@Test 
	public void addVehicleTest(){
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(v1));
	}


	@Test 
	public void removeVehicleTestOk() throws UnknownVehicleException{
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		this.r1.removeVehicle(this.v1);
		assertFalse(this.r1.getAllVehicles().contains(this.v1));
	}

	@Test(expected=UnknownVehicleException.class)
	public void removeVehicleNotHereTest() throws UnknownVehicleException{
		assertFalse(this.r1.getAllVehicles().contains(this.v1));
		this.r1.removeVehicle(v1);
	}


	@Test 
	public void selectTest(){
		List <Vehicle> test = new ArrayList<Vehicle>();
		test.add(this.v1);
		assertTrue(test.contains(this.v1));
		this.r1.addVehicle(this.v1);
		this.r1.addVehicle(this.v2);
		List <Vehicle> rentalList = this.r1.getAllVehicles();
		assertTrue(rentalList.contains(this.v1));
		assertTrue(rentalList.contains(this.v2));
		assertEquals(this.r1.select(this.brandFilter),test);
	}
	
	@Test 
	public void hasRendedVehiculeTest() throws UnknownVehicleException{
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		this.r1.rentVehicle(this.c1, this.v1);
		assertTrue(this.r1.hasRentedAVehicle(this.c1));
	}
	
	@Test 
	public void hasNotRendedVehiculeTest(){
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		assertFalse(r1.hasRentedAVehicle(this.c1));
	}

	@Test 
	public void isRentedTest() throws UnknownVehicleException{
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		this.r1.rentVehicle(this.c1, this.v1);
		assertTrue(this.r1.isRented(this.v1));
	}

	@Test 
	public void isNotRentedTest(){
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		assertFalse(this.r1.isRented(this.v1));
	}

	@Test 
	public void rentVehicleTest() throws UnknownVehicleException, IllegalStateException{
		r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		assertEquals(100.0, this.r1.rentVehicle(this.c1, this.v1),0.0001);
	}

	@Test(expected=UnknownVehicleException.class)
	public void rentVehicleNotExistingTestException() throws UnknownVehicleException, IllegalStateException{
		r1.rentVehicle(this.c1, this.v1);
	}

	@Test(expected=IllegalStateException.class)
	public void rentVehicleButVehicleAlreadyRentedTestException() throws UnknownVehicleException, IllegalStateException{
		r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(v1));
		r1.rentVehicle(this.c1, this.v1);
		assertEquals(100.0, this.r1.rentVehicle(this.c1, this.v1),0.0001);
		r1.rentVehicle(this.c2, this.v1);
	}

	@Test(expected=IllegalStateException.class)
	public void rentVehicleButClientAlreadyRentingTestException() throws UnknownVehicleException, IllegalStateException{
		this.r1.addVehicle(this.v1);
		this.r1.addVehicle(this.v2);
		assertTrue(this.r1.getAllVehicles().contains(this.v1));
		assertTrue(this.r1.getAllVehicles().contains(this.v2));
		assertEquals(100.0, this.r1.rentVehicle(this.c1, this.v1),0.0001);
		this.r1.rentVehicle(this.c1, this.v2);
	}

	@Test 
	public void returnVehicleTest() throws UnknownVehicleException{
		this.r1.addVehicle(this.v1);
		assertTrue(this.r1.getAllVehicles().contains(v1));
		assertEquals(100.0, this.r1.rentVehicle(this.c1, this.v1),0.0001);
		this.r1.returnVehicle(this.c1);
		assertFalse(this.r1.allRentedVehicles().contains(this.v1));
	}

	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient() 
					throws IllegalStateException, UnknownVehicleException {
		RentalAgency agency = new RentalAgency();
		Vehicle v = new Vehicle("Vroum", "Vroum", 2000, 100);
		agency.addVehicle(v);
		Client client1 = new Client("Tim Oleon", 25);
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		assertTrue(agency.hasRentedAVehicle(client1));
		// client2 corresponds to same client than client1 since names are equals
		Client client2 = new Client("Tim Oleon", 25);
		// then test should succeed
		assertTrue(agency.hasRentedAVehicle(client2));
	}
	
	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
	}

}
