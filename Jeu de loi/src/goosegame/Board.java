package goosegame;

public abstract class Board{
    /**
     * attributs
     */
    protected final int nbOfCells;
    protected InterfaceCell[] theCells;

    /**
     * construct a board
     * @param nbOfCells length of the board
     */
    public Board(int nbOfCells){
        this.nbOfCells = nbOfCells +1 ;
    }

    /**
     * initiate a board
     */
    protected abstract void initBoard();

    /**
     * get the cell at i index
     * @param i index
     * @return the cell
     */
    public InterfaceCell getCell(int i){
        return this.theCells[i];
    }

    /**
     * @return number of cell in the board
     */
    public int getNbOfCells(){
        return this.nbOfCells;
    }
}