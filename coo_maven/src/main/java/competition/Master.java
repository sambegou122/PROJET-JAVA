package competition;

import java.util.*;
import competitor.*;
import select.*;
import observer.*;

public class Master extends Competition {

    /**
     * Attributes
     */
    protected int NbGroup;
    protected int NbComPerGroups;
    protected Selection selection;
    protected GroupStage groupStage;
    protected Tournament tournament;

    /**
     * Construct a Master 
     * @param comp List<Competitor> the competitor
     * @param selection it's a class which implement the interace select the way to select competitor 
     * @param NbGroup number of group for the groupStage
     * @param NbComPerGroups number of Competitor per Group for the groupStage
     */
    public Master(List<Competitor> comp, Selection selection , int NbGroup, int NbComPerGroups) {
        super(comp);
        this.selection = selection;
        this.NbGroup = NbGroup;
        this.NbComPerGroups = NbComPerGroups;
    }

    /**
     * @return True if there is enough competitor for the Master else false
     */
    public boolean checkNbCompetitor(List<Competitor> comp) {
        return comp.size() == this.NbGroup*this.NbComPerGroups;
    }

    /**
     * @return the Selection
     */
    public Selection getSelection(){
        return this.selection;
    }

    /**
     * Set a new Selection if you want to change the selection
     * @param newselection
     */
    public void setSelection(Selection newselection){
        this.selection = newselection;
    }

    /**
     * Took every Competitor in the list given in parameter and set their point to 0.
     * @param comp Competitor's List
     */
    public void resetPoint(List<Competitor> comp){
        for(Competitor c : comp){
            c.setPoint(0);
        }
    }

    /**
     * Create and play a Tournament with the list given in parameter
     * @param comp Competitor's List
     */
    protected void playTournament(List<Competitor> comp){
        this.tournament = new Tournament(comp);
        this.addObservers(this.tournament);
        this.tournament.play();
    }
    
    /**
     * Create and play a GroupStage with the list given in parameter
     * @param comp Competitor's List
     */
    protected void playGroupStage(List<Competitor> comp){
        this.groupStage = new GroupStage(comp,this.NbGroup,this.NbComPerGroups);
        this.addObservers(this.groupStage);
        this.groupStage.play();
    }

    /**
     * @param comp CompetitorList 
     * Before starting Master we will check if there is enough Competitor if not will send a message and nothing will happen, this competition take place in 2 phases, the first one is a groupstage.
     * After groupstage done we will select and the selected competitor will play a tournament and give the winner of this Master.
     */
    protected void play(List<Competitor> comp){
        
        if (this.checkNbCompetitor(comp)){
            this.playGroupStage(comp);
            List<Competitor> selected = this.select();
            this.resetPoint(selected);
            this.playTournament(selected);

        }
        else{
            System.out.println("Pas assez de participant");
        }
    }

    /**
     * @return List of selected Competitor
     */
    protected List<Competitor> select(){
        return this.selection.select(this.groupStage);
    }

    
}