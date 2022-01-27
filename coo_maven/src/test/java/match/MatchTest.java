package match;
import match.*;
import observer.*;
import competitor.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MatchTest {
    
    protected MockMatch mm;
    protected List<MatchObserver> l;
    protected MockMatchObserver mj;
    protected MockMatchObserver mb;
    protected Competitor c1;
    protected Competitor c2;
    protected List<Competitor> comp;

    @BeforeEach
    public void init(){
        this.mm = new MockMatch();
        this.c1 = new Competitor("c1");
        this.c2 = new Competitor("c2");
        this.comp = new ArrayList<Competitor>();
        this.comp.add(this.c1);
        this.comp.add(this.c2);
        this.mj = new MockMatchObserver();
        this.mj.addList(this.comp);
        this.mb = new MockMatchObserver();
        this.mb.addList(this.comp);
    }

    @Test
    public void versusTest(){
        this.mm.addObserver(this.mb);
        this.mm.addObserver(this.mj);
        this.mm.versus(this.c1,this.c2);
        assertTrue(this.mm.getNbCalledObservate()==1);
        assertTrue(this.mb.getNbCalledObserv()==1);
        assertTrue(this.mj.getNbCalledObserv()==1);
    }

    @Test
    public void addObserversTest(){
        this.mm.addObserver(this.mb);
        this.mm.addObserver(this.mj);
        assertTrue(this.mm.getObservers().contains(this.mj));
        assertTrue(this.mm.getObservers().contains(this.mb));
    }

    private class MockMatchObserver extends MatchObserver{

        private int nbCalledObserv;

        public MockMatchObserver(){
            super();
            this.nbCalledObserv = 0;
        }

        public void observ(Competitor c1, Competitor c2){     
            this.nbCalledObserv +=1;
        }

        public int getNbCalledObserv(){
            return this.nbCalledObserv;
        }

        public void addList(List<Competitor> c){
            return;
        }
    }

    private class MockMatch extends Match{
        
        private int nbCalledObservate;

        public MockMatch(){
            super();
            this.nbCalledObservate = 0;
        }

        public void versus(Competitor c1, Competitor c2){
            this.observate(c1,c2);
        }

        public void observate(Competitor c1, Competitor c2){
            super.observate(c1,c2);
            this.nbCalledObservate +=1;
        }

        public int getNbCalledObservate(){
            return this.nbCalledObservate;
        }
    }
}
