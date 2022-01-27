package goosegame;

import goosegame.*;

public class ClassicalBoard extends Board{
    
    /**
     * construct the classical board
     */
    public ClassicalBoard(){
        super(63);
    }
    
    /**
     * iniate the classical board
     */
    protected void initBoard(){
        this.theCells = new InterfaceCell[this.nbOfCells];
        for(int i=9;i+1<this.nbOfCells;i+=9){
            this.theCells[i] = new GooseCell(i);
        }
        this.theCells[0] = new StartCell(0);
        this.theCells[31] = new TrapCell(31);
        this.theCells[52] = new TrapCell(52);
        this.theCells[19] = new WaitingCell(19,2);
        this.theCells[6] = new TpCell(6,6);
        this.theCells[42] = new TpCell(42,-12);
        this.theCells[58] = new TpCell(58,-57);

        for(int i=1;i<this.nbOfCells;i++){
            if(this.theCells[i]==null){
                this.theCells[i] = new Cell(i);
            }
        }
    }
}
