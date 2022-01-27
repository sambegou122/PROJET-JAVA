package observer;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;


public interface MatchObserverInterface {

    /**
     * observ the match of two competitors given in parameter
     * @param c1 competitor 1
     * @param c2 competitor 2
     */
    public void observ(Competitor c1,Competitor c2);

}