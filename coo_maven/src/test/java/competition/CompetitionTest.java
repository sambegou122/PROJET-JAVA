package competition;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;
import observer.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public abstract class CompetitionTest {
	
	protected Competitor c1;
	protected Competitor c2;
	protected List<Competitor> Competiteurs;
	protected Competition MyCompetition;
	protected abstract Competition CreateCompetition(List<Competitor> comp);
	protected MockCompetition MockCompet;
	protected MockMatch mm ;
	protected Bookmaker b;

	@BeforeEach
	public void before() {
		this.c1 = new Competitor("sam");
		this.c2 = new Competitor("max");
		this.Competiteurs = new ArrayList<Competitor>();
		this.Competiteurs.add(this.c1);
		this.Competiteurs.add(this.c2);
		this.MockCompet = new MockCompetition(this.Competiteurs);
		this.mm = new MockMatch();
		this.b = new Bookmaker();
	}

	@BeforeEach
	public void init() {
		this.MyCompetition = this.CreateCompetition(this.Competiteurs);
	}
	
	@Test
	public void playTest() {
		this.MockCompet.play();
		assertTrue(this.MockCompet.getNbCalledPlay()==1);
	}

	@Test
	public void protectedPlayTest(){
		this.MockCompet.play();
		assertTrue(this.MockCompet.getNbCalledRanking()==1);
	};

	@Test
	public void playMatchTest(){
		this.MockCompet.play();
		assertTrue(this.MockCompet.getMockMatch().getNbVersusCalled()==1);
	}

	@Test
	public void addObserverTest(){
		
		this.MockCompet.setMatch(this.mm);
		this.MockCompet.addObserver(this.b);
		assertTrue(this.mm.getNbCalledAddObserver()==1);
		
	}

	private class MockCompetition extends Competition {

		private int NbCalledPlay;
		private int NbCalledRanking;
		private MockMatch mockMatch;
		
	
		public MockCompetition(List<Competitor> comp){
			super(comp);
			this.mockMatch = new MockMatch();
			this.NbCalledPlay = 0;
			this.NbCalledRanking = 0;
		}
	
		public int getNbCalledPlay(){
			return this.NbCalledPlay;
		}
		public int getNbCalledRanking(){
			return this.NbCalledRanking;
		}
	
	
		public void play(List<Competitor> c){
			this.NbCalledPlay+=1;
			this.playMatch(c.get(0),c.get(1));
			this.Ranking();
		}

		public void playMatch(Competitor c1, Competitor c2){
			this.mockMatch.Versus(c1,c2);
		}
	
		public  Map <Competitor, Integer> Ranking(){
			this.NbCalledRanking+=1;
			return super.Ranking();
		}

		public MockMatch getMockMatch(){
			return this.mockMatch;
		}
	
	}


	protected class MockMatch extends Match{
	
		private int NbVersusCalled;
		private int nbCalledAddObserver;
		
		public MockMatch(){
			super();
			this.nbCalledAddObserver = 0;
			this.NbVersusCalled = 0;
		}

		public void Versus(Competitor c1 ,Competitor c2){
			
			super.Versus(c1, c2);
			this.NbVersusCalled+= 1;
		}

		public int getNbVersusCalled(){
			return this.NbVersusCalled;
		}

		public void addObserver(MatchObserverInterface o){
			super.addObserver(o);
			this.nbCalledAddObserver+=1;
		}

		public int getNbCalledAddObserver(){
			return this.nbCalledAddObserver;
		}
	}
}
