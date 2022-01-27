package goosegame;

import java.util.Random;

public class Player{

    
    private static Random random = new Random();

    /** current cell of the player */
    protected InterfaceCell cell;
    /** Player's name */
    protected String name;

    /**
     * Construct a player
     * @param name the name of this player
     * @param cell the starting cell of this player
     */
    public Player (String name, InterfaceCell cell){
        this.name = name;
        this.cell = cell;
    }

    /** @see Object#toString() */
    public String toString(){
        return this.name;
    }

    /**
     * @return the current cell of the player
     */
    public InterfaceCell getCell(){
        return this.cell;
    }

    /**
     * changes the cell of the player
     * @param newCell the new cell
     */
    public void setCell(InterfaceCell newCell){
        this.cell=newCell;
    }

    /**
     * @return random result of a 1d6 throw
     */
    private int oneDieThrow(){
        return Player.random.nextInt(6)+1;
    }
    /**
     * @return random result of a 2d6 throw
     */
    public int twoDiceThrow(){
        int result = oneDieThrow()+oneDieThrow();
        return result;
    }
}