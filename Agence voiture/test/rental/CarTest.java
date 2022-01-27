package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
    
    private Car c1;
    private Car c2;

    @Before 
    public void before(){
        this.c1 = new Car("brand1", "model1", 2015, 100.0f,5);
        this.c2 = new Car("brand2", "model2", 2005, 200.0f,3);
    }

    @Test 
    public void getNbPassengerTest(){
        assertTrue(this.c1.getNbpassenger()==5);
        assertTrue(this.c2.getNbpassenger()==3);
    }

    // ---Pour permettre l'execution des tests ----------------------

   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.ClientTest.class);
 }

}
