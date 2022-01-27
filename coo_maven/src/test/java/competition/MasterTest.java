package competition;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;
import select.*;
import observer.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MasterTest extends CompetitionTest{
    
    protected MockMaster mockMaster;
    protected Selection select;
    protected MockSelect mockSelect;
    protected MockMatch mm;


    @BeforeEach
    public void before(){
        super.before();
        this.select = new FirstSelected();
        this.mockSelect = new MockSelect();
        this.mockMaster = new MockMaster(this.Competiteurs,this.select,1,2,this.mockSelect);
        this.mm = new MockMatch();
    }

    @Override
    public Competition CreateCompetition(List<Competitor> comp){
        return new Master(comp,this.select,1, 2);
    }

    
    @Test
    public void protectedPlayTest(){
        this.mockMaster.play();
        assertTrue(this.mockMaster.getNbCalledPlayGroupStage()==1);
        assertTrue(this.mockMaster.getNbCalledCheckCompetitor()==1);
        assertTrue(this.mockSelect.getNbCalledSelect()==1);
        assertTrue(this.mockMaster.getNbCalledPlayTournament()==1);
        assertTrue(this.mockMaster.getNbCalledResetPoint()==1);
        
    }

    @Test
    public void protectedPlayGroupStage(){
        this.mockMaster.play();
        assertTrue(this.mockMaster.getNbCalledAddObservers()==1);
        assertTrue(this.mockMaster.getMockGroupStage().getNbCalledPlay()==1);
    }

    @Test
    public void protectedPlayTournamentTest(){
        this.mockMaster.play();
        assertTrue(this.mockMaster.getNbCalledPlayTournament()==1);
        assertTrue(this.mockMaster.getNbCalledAddObservers()==1);
        assertTrue(this.mockMaster.getMockTournament().getNbCalledPlay()==1);
    }

    @Test
    public void addObserversTest(){
        this.mockMaster.addObserver(this.b);
        this.mockMaster.addObserver(new Journalist());
        this.mockMaster.play();
        assertEquals(this.mockMaster.getMockGroupStage().getNbCalledAddObserv(),this.mockMaster.getObservers().size());
    }

    @Test
    public void checkNbCompetitorTestOk(){
        Master enoughParticipantMaster = new Master (this.Competiteurs,this.select, 1,2);
        assertTrue(enoughParticipantMaster.checkNbCompetitor(this.Competiteurs));
    }

    @Test
    public void checkNbCompetitorTestNotOk(){
        Master notEnoughParticipantMaster = new Master (this.Competiteurs,this.select,2,2);
        assertFalse(notEnoughParticipantMaster.checkNbCompetitor(this.Competiteurs));
    }

    


    private class MockMaster extends Master{

        private int nbCalledPlayGroupStage;
        private int NbCalledPlayTournament;
        private int NbCalledCheckCompetitor;
        private int NbCalledResetPoint;
        private int nbCalledAddObservers;
        private MockSelect mockSelect;
        private MockGroupStage mockGroupStage;
        private MockTournament mockTournament;

        public MockMaster(List<Competitor> comp,  Selection Select,int NbGroup, int NbCompetitorPerGroup, MockSelect mockSelect){
            super(comp,Select, NbGroup, NbCompetitorPerGroup);
            this.NbCalledPlayTournament = 0;
            this.NbCalledCheckCompetitor = 0;
            this.NbCalledResetPoint = 0;
            this.nbCalledAddObservers =0;
            this.nbCalledPlayGroupStage = 0;
            this.mockSelect = mockSelect;   
        }

        public boolean checkNbCompetitor(List<Competitor> comp){
            this.NbCalledCheckCompetitor+=1;
            return super.checkNbCompetitor(comp);
        }

        public void resetPoint(List<Competitor> comp){
            super.resetPoint(comp);
            this.NbCalledResetPoint += 1;
        }

        protected List<Competitor> select(){
            return this.mockSelect.select(this.mockGroupStage);
        }
    

        protected void playGroupStage(List<Competitor> comp){
            this.nbCalledAddObservers =0;
            this.mockGroupStage = new MockGroupStage(comp,this.NbGroup, super.NbComPerGroups);
            this.mockGroupStage.play();
            this.addObservers(this.mockGroupStage);
            this.nbCalledPlayGroupStage+=1;
        }

        protected void playTournament(List<Competitor> comp){
            this.nbCalledAddObservers =0;
            this.mockTournament = new MockTournament(comp);
            this.mockTournament.play();
            this.addObservers(this.mockTournament);
            this.NbCalledPlayTournament+=1;
        }

        protected void addObservers(Competition c){
            super.addObservers(c);
            this.nbCalledAddObservers+=1;
        }

        public int getNbCalledAddObservers(){
            return this.nbCalledAddObservers;
        }

        public int getNbCalledPlayTournament(){
            return this.NbCalledPlayTournament;
        }
        
        public int getNbCalledPlayGroupStage(){
            return this.nbCalledPlayGroupStage;
        }
        public int getNbCalledResetPoint(){
            return this.NbCalledResetPoint;
        }

        public int getNbCalledCheckCompetitor(){
            return this.NbCalledCheckCompetitor;
        }

        public MockSelect getMockSelect(){
            return this.mockSelect;
        }

        public MockGroupStage getMockGroupStage(){
            return this.mockGroupStage; 
        }

        public MockTournament getMockTournament(){
            return this.mockTournament;
        }
    }


    private class MockTournament extends Tournament{

        private int NbCalledPlay;
        private int nbCalledAddObserv;

        public MockTournament(List<Competitor> comp){
            super(comp);
            this.NbCalledPlay=0;
        }

        public void play(){
            super.play();
            this.NbCalledPlay+=1;
        }

        public int getNbCalledPlay(){
            return this.NbCalledPlay;
        }

        public void addObserver(MatchObserverInterface o){
            super.addObserver(o);
            this.nbCalledAddObserv +=1;
        }

        public int getNbCalledAddObserv(){
            return this.nbCalledAddObserv;
        }
    }

    private class MockGroupStage extends GroupStage{
        
        private int NbCalledPlay;
        private int nbCalledAddObserv;


        public MockGroupStage(List<Competitor> comp,int NbGroup,int NbCompetitorPerGroup){
            super(comp,NbGroup,NbCompetitorPerGroup);
            this.NbCalledPlay=0;
            this.nbCalledAddObserv=0;
        }

        public void play(){
            super.play();
            this.NbCalledPlay+=1;
        }

        public int getNbCalledPlay(){
            return this.NbCalledPlay;
        }

        public void addObserver(MatchObserverInterface o){
            super.addObserver(o);
            this.nbCalledAddObserv +=1;
        }

        public int getNbCalledAddObserv(){
            return this.nbCalledAddObserv;
        }
    }

    private class MockSelect extends FirstSelected{

        private int nbCalledSelect;

        public MockSelect(){
            this.nbCalledSelect=0;
        }
        public List<Competitor> select(GroupStage g){
            this.nbCalledSelect+=1;
            return super.select(g);
        }

        public int getNbCalledSelect(){
            return this.nbCalledSelect;
        }
    }

}