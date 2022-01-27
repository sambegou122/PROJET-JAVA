package observer;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;





public abstract class MatchObserverTest {
    
    protected MatchObserver mo;
    protected Competitor c1;
    protected Competitor c2;
    protected List<Competitor> comp;

    protected abstract MatchObserver createMatchObserver();

    @BeforeEach
    public void before(){
        this.c1 = new Competitor("c1");
        this.c2 = new Competitor("c2");
        this.comp = new ArrayList<Competitor>();
        this.comp.add(this.c1);
        this.comp.add(this.c2);
    }

    @BeforeEach
    public void init(){
        this.mo = this.createMatchObserver();
    }


}