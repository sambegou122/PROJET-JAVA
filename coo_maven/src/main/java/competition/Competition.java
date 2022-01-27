package competition;

import java.util.*;
import competitor.*;
import match.*;
import util.*;
import observer.*;

public abstract class Competition implements MatchObserverInterface{
	
	/**Attributs */
	protected Match match;
	protected final List<Competitor> competiteurs;
	protected List<MatchObserverInterface> observers;
	
	/**
	 * Constructors
	 * @param comp (List<Competitor>) is Competitors's list 
	 */
	public Competition (List<Competitor> comp) {
		this.competiteurs = comp;
		this.match = new RandomMatch();
		this.match.addObserver(this);
		this.observers = new ArrayList<MatchObserverInterface>();
	}

	/**
	 * @return Match instance
	 */
	public Match getMatch(){
		return this.match;
	}

	/**
	 * Set a new Match
	 * @param m new Match
	 */
	public void setMatch(Match m){
		this.match = m;
	}

	/**
	 * Start the competition with the attributes competiteurs
	 */
	public void play(){
		this.play(this.competiteurs);
	};

	
	/**
	 * Play a Match with two competitors
	 * @param c1 first competitor
	 * @param c2 second competitor
	 */
	protected void playMatch(Competitor c1, Competitor c2){
		this.match.Versus(c1,c2);
	}

	protected abstract void play(List<Competitor> comp);

	/**
	 * Rank the competitors in descending order according to their points
	 * @return (Map <Competitor, Integer> ) the Ranking Map
	 */
	public  Map <Competitor, Integer> Ranking(){
		Map <Competitor, Integer> Mymap = new HashMap<>();
		for(Competitor c:this.competiteurs){
			Mymap.put(c, c.getPoint());
		}
		return MapUtil.sortByDescendingValue(Mymap);

	}

	/**
	 * show the Competitor's Map
	 * @param Ranger (Map <Competitor, Integer> ) the Ranking Map
	 */
	public void affiche(Map <Competitor, Integer> Ranger ){
		Set<Competitor> key = Ranger.keySet();
		System.out.println("                  ");
		System.out.println("*** Ranking ***");
		for (Competitor k : key) {
			System.out.println(k.toString());
			
		}

	}
	/**
	 * Getters
	 * @return the match observers
	 */
	public List<MatchObserverInterface> getObservers(){
		return this.observers;
	}
	/**
	 * add a new Match observer in the list of observers
	 * @param obs (a new observer)
	 */
	public void addObserver(MatchObserverInterface obs){
		this.observers.add(obs);
		this.match.addObserver(obs);
	}
	
	/**
	 * add one point to the first competitor given in parameter
	 * @param c1 Winner
	 * @param c2 Loser 
	 */
	public void observ(Competitor c1, Competitor c2){
		c1.addPoint(1);   
	}
	/**
	 * add the list of observers in a competition
	 * @param c (a competition)
	 */
	protected void addObservers(Competition c){
        for(MatchObserverInterface o : this.observers){
            c.addObserver(o);
        }
    }
}