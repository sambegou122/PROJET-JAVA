package main;

import java.util.ArrayList;
import java.util.List;
import competition.*;
import competitor.*;
import select.*;
import observer.*;

public class MasterMain {

    public static void main(String[] args) {
        List<Competitor> MesCompetiteurs = new ArrayList<>();
        for(int i = 0; i < 16; i++){
                MesCompetiteurs.add(new Competitor(Integer.toString(i)));
        }
        Bookmaker b = new Bookmaker();
        Journalist j = new Journalist();
        Selection myselection = new FirstSelected();
        Master master = new Master(MesCompetiteurs, myselection, 4, 4 );
        master.addObserver(b);
        master.addObserver(j);
        b.addList(MesCompetiteurs);
        master.play();


    }
    
    
}
