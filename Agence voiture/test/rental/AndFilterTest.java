package rental;

import org.junit.*;
import static org.junit.Assert.*;
import rental.*;


public class AndFilterTest {

    @Test
    public void addFilterTestOk(){
        BrandFilter brandfilter = new BrandFilter("brand1");
        AndFilter andfilter = new AndFilter();
        andfilter.addFilter(brandfilter);
        assertTrue(andfilter.getVehicleFilter().contains(brandfilter));
    }
    
    @Test
    public void acceptTestOk(){
        BrandFilter brandfilter = new BrandFilter("brand1");
        AndFilter andfilter = new AndFilter();
        Vehicle v1 = new Vehicle("brand1", "modelTest", 2020, 30);
        Vehicle v2 = new Vehicle("brand2", "model2", 2000, 200);
        andfilter.addFilter(brandfilter);
        assertTrue(andfilter.accept(v1));
        assertFalse(andfilter.accept(v2));
    }
















    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(rental.AndFilterTest.class);
    }
}
