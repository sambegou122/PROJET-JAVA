package observer;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

public class Bookmaker extends MatchObserver{

    /**
     * attritus
     */
    protected HashMap<Competitor, Integer> map;

    /**
     * constructor
     */
    public Bookmaker(){
        super();
        this.map = new HashMap<Competitor,Integer>();
    }

    /**
     * 
     * Add one point for the second competitor (the one who lost ) and remove one point for the other one but stay at 1 if it's equals to 1.
     * @param c1 competitor 1
     * @param c2 competitor 2
     */
    public void observ(Competitor c1, Competitor c2){
        int cotePerdant = this.map.get(c2);
        this.map.put(c2, (cotePerdant+1));
        int coteGagnant = this.map.get(c1);
        if(coteGagnant != 1){
            this.map.put(c1, (coteGagnant-1));
        }
        int cotePF = this.map.get(c2);
        int coteGF = this.map.get(c1);
        System.out.println("Victoire de : "+c1.getName()+" (cote : "+ coteGF +") face à "+c2.getName()+" (cote : "+ cotePF +").");
    }

    /**
     * add the list of competitors to the HashMap<Competitor, Integer> and start at 1 as rate
     * @param comp CompetitorList
     */
    public void addList(List<Competitor> comp){
        for(Competitor c : comp){
            this.map.put(c, 1);
        }
    }

    /**
     * getter
     * @return the map of competitors
     */
    public HashMap<Competitor, Integer> getMap(){
        return this.map;
    }

    /**
     * getters
     * @param c competitor
     * @return the cote of competitor 
     */
    public int getCompRating(Competitor c){
        return this.map.get(c);
    }
}