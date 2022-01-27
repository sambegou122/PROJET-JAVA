package util;
import util.Puissance;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PuissanceTest {
    
    private Puissance pui2;
    private Puissance pui3;

    @BeforeEach
    public void init(){
        this.pui2 = new Puissance(2);
        this.pui3 = new Puissance(3);
    }

    @Test
    public void puissanceTest(){
        assertTrue(this.pui2.puissance(16));
        assertFalse(this.pui2.puissance(10));
        assertTrue(this.pui3.puissance(81));
        assertFalse(this.pui2.puissance(36));
    }
}
