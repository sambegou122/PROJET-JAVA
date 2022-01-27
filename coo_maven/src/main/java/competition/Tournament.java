package competition;
import java.util.*;
import competitor.*;
import util.*;

public class Tournament extends Competition {

	/**
	 * Constructor
	 * For more information check Competition documentation
	 */
	public Tournament(List<Competitor> comp){
		super(comp);
	}
		
	/**
	 * Start the Tournament, during the tournament will be played in different round in 1vs1.
	 * After a win the competitor is qualified the other one is eliminated.
	 * The winner is the competitor has the same point as number of round played.
	 * @param comp (List<Competitor>) is Competitors's list 
	 */
	protected void play(List<Competitor> comp){
		Puissance p = new Puissance(2);
		if(!p.puissance(this.competiteurs.size())){
			System.out.println("Pour ce tournoi il faut 2^n partipants.");
		}
		else{
			List <Competitor> newComp = new ArrayList<Competitor>();
			newComp.addAll(this.competiteurs);
			int i =1;
			while(newComp.size()>1){
				System.out.println("         ");
				System.out.println("**** Tour "+i + " ***");
				
				i+=1;
				newComp = this.playOneRound(newComp);
				
			}
			
			this.affiche(this.Ranking());
			System.out.println("                  ");
		}
	}

	/**
	 * Play a round of the actual tournament.
	 * @param comp the qualified competitors
	 * @return the competitor who won this round
	 */
	protected List<Competitor> playOneRound(List<Competitor> comp){
		for(int i = 0 ; i< comp.size();i++){
			Competitor c1 = comp.get(i);
			Competitor c2 = comp.get(i+1);
			this.playMatch(c1,c2);
			if(c1.getPoint()>c2.getPoint()){
				comp.remove(c2);
			}
			else{
				comp.remove(c1);
			}
			
		}
		return comp;
	}
	
	
	
}
