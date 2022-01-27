package goosegame;

public interface InterfaceCell {

    /**
     * @return if in this cell the player can move or not;
     */
    public boolean canMove();

    /**
     * @return if in this cell the player can jump
     */
    public boolean canJump();

    /**
     * @param n the throws of the player
     * @return the advance of the pawn
     */
    public int jump(int n);

    /**
     * @return the player in the cell
     */
    public Player getPlayer();

    /** set a player in the cell
     * @param Player 
     */
    public void setPlayer(Player p);

    /**
     * @return Cell's postion
     */
    public int getPosition();

    /**
     * @return the Cell's type
     */
    public String toString();

    /** set no player in the cell
     */
    public void empty();
} 