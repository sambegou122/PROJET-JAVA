package select;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;
import select.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public abstract class SelectionTest {

    protected Competitor c1;
	protected Competitor c2;
	protected List<Competitor> Competiteurs;
    protected MockGroupStage mockGroupStage;
    protected Selection mySelection;
    protected abstract Selection createSelection();

    @BeforeEach
    public void before(){
        this.c1 = new Competitor("sam");
		this.c2 = new Competitor("max");
		this.Competiteurs = new ArrayList<Competitor>();
		this.Competiteurs.add(this.c1);
		this.Competiteurs.add(this.c2);
		this.mockGroupStage = new MockGroupStage(this.Competiteurs,1,2);
    }
    
    @BeforeEach
    public void init(){
        this.mySelection = this.createSelection();
    }

    protected class MockGroupStage extends GroupStage{

        private int NbCalledGetLeagues;

        public MockGroupStage(List<Competitor> comp, int NbGroup, int NbCompetitorPerGroup){
            super(comp,NbGroup,NbCompetitorPerGroup);
            this.NbCalledGetLeagues= 0;
        }

        public List<League> getLeagues(){
            this.NbCalledGetLeagues+=1;
            return super.getLeagues();
        }

        public int getNbCalledGetLeagues(){
            return this.NbCalledGetLeagues;
        }

    }


}