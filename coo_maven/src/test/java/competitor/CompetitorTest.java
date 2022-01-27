package competitor;
import competitor.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompetitorTest {

    protected Competitor c1;
    protected Competitor c2;


    @BeforeEach
    public void init(){
        this.c1 = new Competitor("1");
        this.c2 = new Competitor("2");
    }

    @Test
    public void equalsTestOk(){
        assertTrue(this.c1.equals(this.c1));
    }

    @Test
    public void equalsTestNotOk(){
        assertFalse(this.c1.equals(this.c2));
    }
}
