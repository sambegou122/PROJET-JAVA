package match;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;
import observer.*;

public class Match implements InterfaceMatch{

    /** 
     * Attributs
    */
    protected List<MatchObserverInterface> observers;

    /** Constructor */
    public Match(){
        this.observers = new ArrayList<MatchObserverInterface>();
    }

    public void Versus(Competitor c1 ,Competitor c2){
        
    }

    /**
     * This function will call the function observ of all the Match Observer in the list.
     * @param c1 Competitor 1
     * @param c2 Competitor 2
     */
    public void observate(Competitor c1, Competitor c2){
        for(MatchObserverInterface o : this.observers){
            o.observ(c1,c2);
        }
    }

    /**
     * add one match to the observers
     * @param o match observer
     */
    public void addObserver(MatchObserverInterface o){
        this.observers.add(o);
    }

    /**
     * getters
     * @return the list of observers
     */
    public List<MatchObserverInterface> getObservers(){
        return this.observers;
    }

}
