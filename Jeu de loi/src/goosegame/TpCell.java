package goosegame;

public class TpCell implements InterfaceCell {


    private int position;
    private int tp;
    private Player joueur;


    /**
     * 
     * @param pos the player's position
     * @param tp the teleportation position 
     */
    public TpCell(int pos,int tp){
      this.position = pos;
      this.tp = tp;
      this.joueur=null;
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
      return n+this.tp;
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
      return "cell "+ Integer.toString(this.position) + " (Teleport to " +Integer.toString(this.position+this.tp) + " )";
    }
  
    /** set no player in the cell
     */
    public void empty(){
      this.joueur = null;
    }    
}
