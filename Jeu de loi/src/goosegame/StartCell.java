package goosegame;

import java.util.*;

public class StartCell implements InterfaceCell{
    /**
     * the list of players
     */
    private List<Player> players;

    /**
     * the palyers's position
     */
    private int position;

    /**
     * 
     * @param pos the palyers's position
     */
    public StartCell(int pos){
        this.joueur = null;
        this.position = pos;
        this.players = new ArrayList<Player>();
    }

    /**
     * @return if in this cell the player can move or not;
     */
    public boolean canMove(){
        return true;
    }

    /**
     * @return if in this cell the player can jump
     */
    public boolean canJump(){
        return false;
    }

    /**
     * @param n the throws of the player
     * @return the advance of the pawn
     */    
    public int jump(int n){
        return 0;
    }



    /**
    * @return Cell's postion
    */
    public int getPosition(){
        return this.position;
    }


    /**
     * @return the Cell's type
     */
    public String toString(){
        return "start cell";
    }

    /** set no player in the cell
     */
    public void empty(){
        this.joueur = null;
    }    

    /**
    * @return the player in the cell
    */
    public Player getPlayer(){
        return null;
    }


    /** set a player in the cell
    * @param Player 
    */
    public void setPlayer(Player p){
        this.players.add(p);
    }
}
