package competition;
import java.util.*;
import competition.*;
import match.*;
import competitor.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroupeStageTest extends CompetitionTest {

    protected MockGroupStage mockGroupStage;
    

    @BeforeEach
    public void before(){
        super.before();
        this.mockGroupStage = new MockGroupStage(this.Competiteurs,1,2);
    }

    @Override
    public Competition CreateCompetition(List<Competitor> comp){
        return new GroupStage(comp, 1, 2);
    }

    @Test
    public void protectedPlayTest(){
        this.mockGroupStage.play();
        assertTrue(this.mockGroupStage.getNbCalledGenerateLeagues()==1);
        List<MockLeague> leaguesTest = this.mockGroupStage.getMockLeagues();
        for(MockLeague leagueTest : leaguesTest){
            assertTrue(leagueTest.getNbCalledPlay()==1);
        }
    }

    private class MockGroupStage extends GroupStage{

        private List<MockLeague>  mockLeagues;
        private int NbCalledGenerateLeagues;

        public MockGroupStage(List<Competitor> comp,int NbGroup,int NbCompetitorPerGroup){
            super(comp,NbGroup,NbCompetitorPerGroup);
            this.mockLeagues = new ArrayList<>();
            this.NbCalledGenerateLeagues=0;
        }

        protected void generateLeagues(List<Competitor> comp){
            for (int i = 0; i < super.NbGroup; i++) {
                List<Competitor> newcomp= new ArrayList<Competitor>();
                for (int j = 0; j < super.NbComParGroups; j++) {
                    Competitor c = comp.get(j+(super.NbComParGroups*i));
                    newcomp.add(c);
                    
                }
                MockLeague l = new MockLeague(newcomp);
                this.mockLeagues.add(l);
            }
            this.NbCalledGenerateLeagues+=1;
        }

        protected void play(List<Competitor> comp){
            this.generateLeagues(comp);
            int cnt = 1;
            for (MockLeague L : this.mockLeagues) {
                System.out.println("Le groupe " + cnt + " commence !\n");
                L.play();
                cnt+=1;
            }
    
        }

        public int getNbCalledGenerateLeagues(){
            return this.NbCalledGenerateLeagues;
        }

        public List<MockLeague> getMockLeagues(){
            return this.mockLeagues;
        }
    }

    private class MockLeague extends League{

        private int NbCalledPlay;

        public MockLeague(List<Competitor> comp){
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
    }
}
