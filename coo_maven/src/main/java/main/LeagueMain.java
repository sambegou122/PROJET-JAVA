package main;

import java.util.ArrayList;
import java.util.List;

import competition.*;
import competitor.*;

public class LeagueMain {
	
	public static void main(String[] args) {
                List<Competitor> MesCompetiteurs = new ArrayList<>();
                for(int i = 0; i < args.length; i++){
                        MesCompetiteurs.add(new Competitor(args[i]));
                }
                League Lg = new League(MesCompetiteurs);
                Lg.play();
	}
}