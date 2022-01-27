package goosegame;

import org.junit.*;
import static org.junit.Assert.*;



public class TpCellTest {
    
    private InterfaceCell cell;

    @Before
    public void before(){
        this.cell = new TpCell(10,12);
    }

    @Test
    public void canMoveTest(){
        assertTrue(this.cell.canMove());
    }

    @Test
    public void canJumpTest(){
        assertTrue(this.cell.canJump());
    }

    @Test
    public void JumpTest(){
        assertEquals(this.cell.jump(5), 17);
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
        return new junit.framework.JUnit4TestAdapter(goosegame.TpCellTest.class);
    }
}
