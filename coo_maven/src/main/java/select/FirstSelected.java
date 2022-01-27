package select;
import java.util.*;
import competitor.*;
import competition.*;

public class FirstSelected implements Selection{


    /**
     * This method select the first competitor of each league played in groupStage
     * @param g (A GroupeStage)
     * @return the selected Competitor
     */
    public List<Competitor> select (GroupStage g){
        List<League> Leagues = g.getLeagues();
        List <Competitor> selected = new ArrayList<Competitor>();
        for (League league : Leagues){
            List<Competitor> c = new ArrayList<>(league.Ranking().keySet());
            selected.add(c.get(0));

        } 
        return selected;
    }
    
}
