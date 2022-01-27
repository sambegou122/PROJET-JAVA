package goosegame;

public class WaitingCell implements InterfaceCell {
    
    private int position;
    private Player joueur;
    private int compteur;
    private int wait;

    /**
     * 
     * @param pos the waiting cell position
     * @param comp the counter of waiting turn
     */
    public WaitingCell(int pos,int comp){
        this.position = pos;
        this.compteur=0;
        this.wait = comp;
        this.joueur=null;
    }

    /**
     * @return if in this cell the player can move or not;
     */
    public boolean canMove(){
        if(this.compteur<this.wait){
            this.compteur +=1;
            return false;
        }
        return true;
    };

    /**
     * @return if in this cell the player can jump
     */
    public boolean canJump(){
        return false;
    };

        /**
     * @param n the throws of the player
     * @return the advance of the pawn
     */
    public int jump(int n){
        return 0;
    }

    /**
    * @return the player in the cell
    */
    public Player getPlayer(){
      return this.joueur;
    }

    /** set a player in the cell
    * @param Player 
    */
    public void setPlayer(Player p){
      this.joueur = p;
      this.compteur=0;
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
      return "cell " + Integer.toString(this.position) +"(waiting for " + this.wait +" turn )";
    }

    /** set no player in the cell
     */
    public void empty(){
        this.joueur = null;
    }    
}
