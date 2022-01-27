package match;
import competitor.*;
import observer.*;
import java.util.*;

public interface InterfaceMatch {

    /**
     * This function play a match between both competittor and give a point for the winner
     * @param c1 Competitor 1
     * @param c2 Competitor 2
     */
    public void Versus(Competitor c1 ,Competitor c2);

    /**
     * This function will send to all observer both competitor and call the function observ
     * @param c1 Competitor 1
     * @param c2 Competitor 2
     */
    public void observate(Competitor c1, Competitor c2);

    public void addObserver(MatchObserverInterface o);

    public List<MatchObserverInterface> getObservers();

}
