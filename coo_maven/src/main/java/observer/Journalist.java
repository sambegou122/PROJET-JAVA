package observer;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

public class Journalist extends MatchObserver{
    

    /** Constructor */
    public Journalist(){
    }

    
    public void observ(Competitor c1, Competitor c2){
        System.out.println("Le vainqueur dans ce match est : "+ c1.getName()+ " mais belle performance de "+c2.getName());
    }
}