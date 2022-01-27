package competition;

import java.util.*;
import competitor.*;

public class League extends Competition {

	/**
	 * Constructor
	 * For more information check Competition documentation
	 */
	public League(List<Competitor> comp){
		super(comp);
	}

	/**
	 * Start the League , every competitor has to meet twice their opponent.
	 * The winner is the competitor with the most point.
	 * @param comp (List<Competitor>) is Competitors's list 
	 */
	protected void play(List<Competitor> comp){
		for(Competitor c1 : comp){
			for(Competitor c2 : comp){
				if(!c1.equals(c2)){
					this.playMatch(c1,c2);
				}
			}
		}
		
		this.affiche(this.Ranking());
		System.out.println("                  ");
	}


}
