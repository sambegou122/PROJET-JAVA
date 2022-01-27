
package competition;

import java.util.*;
import competitor.*;

public class GroupStage extends Competition{

    /**Attributs */
    protected int NbGroup;
    protected int NbComParGroups;
    protected List<League>Leagues;

    /**
     * constructor
     * @param comp (List<Competitor>) is Competitors's list'
     * @param NbGroup (int) number of groups
     * @param NbComParGroups (int) number of competitor per groups
     */
    public GroupStage(List<Competitor> comp, int NbGroup , int NbComParGroups){
        super(comp);
        this.NbGroup = NbGroup;
        this.NbComParGroups = NbComParGroups;
        this.Leagues = new ArrayList<League>();


    }

    /**
     * Getters
     * @return the list of League in competition
     */
    public List<League> getLeagues () {
        return this.Leagues;
    }


    /**
     * Generate the Leagues from the list in param
     * @param comp (List<Competitor>) is the of competitor
     */
    protected void generateLeagues(List<Competitor> comp){
        for (int i = 0; i < this.NbGroup; i++) {
            List<Competitor> newcomp= new ArrayList<Competitor>();
            for (int j = 0; j < this.NbComParGroups; j++) {
                Competitor c = comp.get(j+(this.NbComParGroups*i));
                newcomp.add(c);
                
            }
            League l = new League(newcomp);
            this.addObservers(l);
            this.Leagues.add(l);
        }
    }

    /**
     * Play every League generate by (generateLeagues) method
     * @param comp (List<Competitor>) is the of competitor
     */
    protected void play(List<Competitor> comp){
        this.generateLeagues(comp);
        int cnt = 1;
        for (League L : this.Leagues) {
            System.out.println("Le groupe " + cnt + " commence !\n");
            L.play();
            cnt+=1;
        }

    }

    

}