package match;
import java.util.Random;
import competitor.Competitor;
import observer.*;

public class RandomMatch extends Match {

    /**
     * Constructor
     */
    public RandomMatch(){
        super();
    }


    public void Versus(Competitor c1, Competitor c2){
        String res = c1.getName() + " vs " + c2.getName() + " --> ";
        Random r = new Random();
        int winner = r.nextInt(2);
        if(winner == 0){
            System.out.println(res + c1.getName()+" wins !");
            this.observate(c1,c2);
        }
        else{
            System.out.println(res + c2.getName()+" wins !");
            this.observate(c2,c1);
        }
    }
    
}