package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JournalistTest extends MatchObserverTest{
    
    protected Journalist j;

    protected MatchObserver createMatchObserver(){
        return new Journalist();
    }

    @BeforeEach
    public void before_b(){
        this.j = new Journalist();
    }
}