package goosegame;

public class TrapCell implements InterfaceCell{

    private int position;
    private Player joueur;


    /**
     * 
     * @param pos the Trapcell's position
     */
    public TrapCell(int pos){
      this.position=pos;
      this.joueur=null;
    };

    /**
     * @return if in this cell the player can move or not;
     */
    public boolean canMove(){
        return false;
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
      return "Cell " + Integer.toString(this.position)+ "(Trap)";
    }

    /** set no player in the cell
     */
    public void empty(){
      this.joueur = null;
    }    
}
