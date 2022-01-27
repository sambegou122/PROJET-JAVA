package goosegame;

import org.junit.*;
import static org.junit.Assert.*;


public class PlayerTest {


    private Player tester;
    private InterfaceCell cell;
    private InterfaceCell cell2;

    @Before
    public void before(){
        this.cell = new Cell(10);
        this.cell2 = new Cell(12);
        this.tester=new Player("timoleon",cell);
    }

    @Test
    public void toStringTest(){
        assertEquals("timoleon",this.tester.toString());
    }

    @Test
    public void getCellTest(){
        assertSame(this.cell,this.tester.getCell());
    }

    @Test
    public void setCellTest(){
        assertSame(this.cell,this.tester.getCell());
        this.tester.setCell(this.cell2);
        assertSame(this.cell2,this.tester.getCell());
    }
    
     // ---Pour permettre l'exécution des test----------------------
     public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.PlayerTest.class);
    }
}
