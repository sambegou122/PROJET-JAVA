package goosegame;

import org.junit.*;
import static org.junit.Assert.*;


public class TrapCellTest {
    private InterfaceCell cell;

    @Before
    public void before(){
        this.cell = new TrapCell(10);
    }

    @Test
    public void canMoveTest(){
        assertFalse(this.cell.canMove());
    }

    @Test
    public void canJumpTest(){
        assertFalse(this.cell.canJump());
    }

    @Test
    public void JumpTest(){
        assertEquals(this.cell.jump(0), 0);
    }

    @Test
    public void getPositionTest(){
        assertEquals(this.cell.getPosition() , 10);

    }

    @Test
    public void getPlayerTest(){
        assertEquals(this.cell.getPlayer(), null);
        

    }


    @Test
    public void setPlayerTest(){
        Player ib = new Player("ib", this.cell);
        this.cell.setPlayer(ib);
        assertSame(this.cell.getPlayer(), ib);
        

    }

    @Test
    public void emptyTest(){
        Player ib = new Player("ib", this.cell);
        this.cell.setPlayer(ib);
        this.cell.empty();
        assertEquals(this.cell.getPlayer(), null);
        

    }

     // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.TrapCellTest.class);
    }
}
