package competition;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LeagueTest extends CompetitionTest{

	protected MockLeague MockLeague;
	
	public Competition CreateCompetition(List<Competitor> comp) {
		return new League(comp);
	}

	@Test
	public void protectedPlayTest(){
		int n = this.Competiteurs.size();
		this.MockLeague = new MockLeague(this.Competiteurs);
		this.MockLeague.play();
		assertTrue(this.MockLeague.getNbCalledPlayMatch()== n*(n-1));
	}

	private class MockLeague extends League {
    
		private int NbCalledPlayMatch;
	
		public MockLeague(List<Competitor> comp){
			super(comp);
			this.NbCalledPlayMatch = 0;
			
		}
	
		public int getNbCalledPlayMatch(){
			return this.NbCalledPlayMatch;
		}
	
		public void playMatch(Competitor c1, Competitor c2){
			super.playMatch(c1,c2);
			this.NbCalledPlayMatch+=1;
		}
	
	}
}
