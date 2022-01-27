package observer;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BookmakerTest extends MatchObserverTest{
    
    protected Bookmaker b;

    @BeforeEach
    public void before_b(){
        this.b = new Bookmaker();
    }
    
    protected MatchObserver createMatchObserver(){
        return new Bookmaker();
    }

    @Test
    public void addListTest(){
        this.b.addList(this.comp);
        assertTrue(this.b.getMap().containsKey(this.c1));
        assertTrue(this.b.getMap().containsKey(this.c2));
        assertTrue(this.b.getCompRating(this.c1)==1);
        assertTrue(this.b.getCompRating(this.c2)==1);
    }

    @Test
    public void observTest(){
        this.b.addList(this.comp);
        this.b.observ(this.c1,this.c2);
        assertTrue(this.b.getCompRating(c1)==1);
        assertTrue(this.b.getCompRating(c2)==2);
    }


}