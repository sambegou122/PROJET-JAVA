package goosegame;

import java.util.*;

public class Game{
    /**
     * attributs
     */
    protected List<Player> thePlayers;
    protected Board theBoard;

    /**
     * Construct a goose game with the board given in parameter 
     * @param theBoard the board for goose game
     */
    public Game(Board theBoard){
        this.theBoard = theBoard;
        this.thePlayers = new ArrayList<Player>();
        
    }

    /**
     * add a player to the goose game
     * @param joueur the player
     */
    public void addPlayer(Player joueur){
        this.thePlayers.add(joueur);
    }
    
    /**
     * play a game with description of the party
     */
    public void play(){
        for(Player joueur : this.thePlayers){
            joueur.setCell(this.theBoard.getCell(0));
            this.theBoard.getCell(0).setPlayer(joueur);
        }
        boolean finish=false;
        while(finish==false){
            
            for( Player joueur : this.thePlayers){

                String phrase = "";
                
                String nom = joueur.toString();
                int pos = joueur.getCell().getPosition();
                // for each on prend joueur suivant

                
                // on vérifie si le joueur peux jouer si oui on lance le dé
                    
                if(joueur.getCell().canMove()){
                    // il lance
                    phrase = phrase + nom + " is in cell " + Integer.toString(theBoard.getCell(pos).getPosition());
                    int lancee = joueur.twoDiceThrow();

                    phrase = phrase + " and throw "+ Integer.toString(lancee);
                    if((pos+lancee) >= this.theBoard.getNbOfCells()){
                        lancee = this.theBoard.getNbOfCells()-pos-lancee-1;
                      
                    }

                    phrase = phrase + " and reaches " + this.theBoard.getCell(pos+lancee).toString();
                    
                    
                    
                    // on vérifie si la case à un "rebond"
                    // si oui alors on applique le rebond
                    if(this.theBoard.getCell(pos+lancee).canJump()){
                        lancee = this.theBoard.getCell(pos+lancee).jump(lancee);
                        if((pos+lancee) >= this.theBoard.getNbOfCells()){
                            lancee = this.theBoard.getNbOfCells()-lancee-pos-1;
                        }
                        phrase = phrase + " and jump to "+ this.theBoard.getCell(pos+lancee).toString() ;
                    }
                    
                    // on regarde si la case ou il va tomber est occupée
                    if(this.theBoard.getCell(pos+lancee).getPlayer()!=null){
                        phrase = phrase + " cell is busy ... ";
                        Player joueur2 = this.theBoard.getCell(pos+lancee).getPlayer();
                        joueur2.setCell(joueur.getCell());
                        this.theBoard.getCell(pos).setPlayer(joueur2);
                        this.theBoard.getCell(pos+lancee).setPlayer(joueur);
                        joueur.setCell(this.theBoard.getCell(pos+lancee));
                        phrase = phrase + " ... " + joueur2.toString() + " is sent to " + this.theBoard.getCell(pos).toString();
                        // si oui on echange les positions
                    }
                    
                    else{
                        this.theBoard.getCell(pos).empty();
                        this.theBoard.getCell(pos+lancee).setPlayer(joueur);
                        joueur.setCell(this.theBoard.getCell(pos+lancee));    
                        // sinon on met le joueur à sa nouvelle case et on vide la case précédente
                    }
                    
                    
                    // on vérifie si la dernière case est occupé
                    // si oui finish = true                
                }
                else{
                    phrase = phrase + joueur.toString()+" cannot play";
                }
                
                if(this.theBoard.getCell(this.theBoard.getNbOfCells()-1).getPlayer()!=null){
                    phrase= phrase + nom +" has won";
                    finish = true;
                    System.out.println(phrase);
                    break;
                }
                System.out.println(phrase);
            }
        }
    }
}