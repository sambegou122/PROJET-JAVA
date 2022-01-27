package competition;
import java.util.*;
import java.util.*;
import competitor.*;
import util.*;
import match.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TournamentTest extends CompetitionTest{

	private MockTournament mockTournament;
	
	public Competition CreateCompetition(List<Competitor> comp) {
		return new Tournament(comp);
	}

	@Test
	public void protectedPlayTest(){
		int n = this.Competiteurs.size();
		this.mockTournament = new MockTournament(this.Competiteurs);
		this.mockTournament.play();
		assertTrue(this.mockTournament.getNbCalledPlayMatch()== (n-1));
	}

	private class MockTournament extends Tournament {

		private int NbCalledPlayMatch;
	
		public MockTournament(List<Competitor> comp){
			super(comp);
			this.NbCalledPlayMatch=0;
		}
	
		public void playMatch(Competitor c1, Competitor c2){
			super.playMatch(c1,c2);
			this.NbCalledPlayMatch+=1;
	
		}
	
		public int getNbCalledPlayMatch(){
			return this.NbCalledPlayMatch;
		}
	
	}
}
