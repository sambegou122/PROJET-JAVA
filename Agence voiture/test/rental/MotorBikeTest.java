package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorBikeTest {
    
    private Motorbike b1;
    private Motorbike b2;

    @Before 
    public void before(){
        this.b1 = new Motorbike("brand1", "model1", 2015, 100.0f,12.0f);
        this.b2 = new Motorbike("brand2", "model2", 2005, 200.0f,15);
    }


    @Test 
    public void getNbPassengerTest(){
        assertTrue(this.b1.getcyl()==12.0f);
        assertTrue(this.b2.getcyl()==15);
    }
    // ---Pour permettre l'execution des tests ----------------------

   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.ClientTest.class);
 }
}
