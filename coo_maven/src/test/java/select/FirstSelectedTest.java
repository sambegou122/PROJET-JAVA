package select;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class FirstSelectedTest extends SelectionTest{
    

    @Override
    protected Selection createSelection(){
        return new FirstSelected();
    }

    @Test
    public void selectTest(){
        this.mySelection.select(this.mockGroupStage);
        assertTrue(this.mockGroupStage.getNbCalledGetLeagues()==1);
    }


}