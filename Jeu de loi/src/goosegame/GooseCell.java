package goosegame;

public class GooseCell implements InterfaceCell {
    /**
     * attributs
     */
    private int position;
    private Player joueur;

    /**
     * Construct a goose cell with the position given in parameter
     * @param pos the Cell's position
     */
    public GooseCell(int pos){
        this.joueur=null;
        this.position=pos;
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
        return true;
    }

    /**
     * @param n the throws of the player
     * @return the advance of the pawn
     */
    public int jump(int n){
        return n*2;
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
        return "cell " + Integer.toString(this.position) + " (goose)";
    }
    
    /** set no player in the cell
     */
    public void empty(){
        this.joueur = null;
    }    
}
