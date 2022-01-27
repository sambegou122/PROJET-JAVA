
package goosegame;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;
public class StartCellTest {

    @Test
    public void canMoveTest(){
        InterfaceCell cell = new StartCell(10);
        assertTrue(cell.canMove());
    }

    @Test
    public void canJumpTest(){
        InterfaceCell cell = new StartCell(10);
        assertFalse(cell.canJump());
    }

    @Test
    public void JumpTest(){
        InterfaceCell cell = new StartCell(10);
        assertEquals(cell.jump(0), 0);
    }

    @Test
    public void getPositionTest(){
        InterfaceCell cell = new StartCell(10);
        assertEquals(cell.getPosition() , 10);

    }

    @Test
    public void getPlayerTest(){
        InterfaceCell cell = new StartCell(10);
        assertEquals(cell.getPlayer(), null);
        

    }


    @Test
    public void setPlayerTest(){
        InterfaceCell cell = new StartCell(10);
        Player ib = new Player("ib", cell);
        cell.setPlayer(ib);
        assertEquals(cell.getPlayer(), null);
        

    }

    @Test
    public void emptyTest(){
        InterfaceCell cell = new StartCell(10);
        Player ib = new Player("ib", cell);
        cell.setPlayer(ib);
        cell.empty();
        assertEquals(cell.getPlayer(), null);
        

    }

     // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(goosegame.StartCellTest.class);
    }

    
}
