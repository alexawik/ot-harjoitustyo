
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ot.operations.Savellajit;
import ot.operations.TehtavanSuoritus;


public class TehtavanSuoritusTest {
    Savellajit savellajit;
    TehtavanSuoritus suoritus;
    
    @Before
    public void setUp() throws Exception {
        savellajit = new Savellajit("savellajit.txt");
        suoritus = new TehtavanSuoritus();
    }
    
    @Test
    public void suoritettavaToimii() {
        suoritus.setSuoritettava(savellajit);
        assertTrue(suoritus.getSuoritettava().getEtumerkkeja() < 8);
    }
    
    @Test
    public void tehtavaMeneeOikein() {
        suoritus.setSuoritettavaManuaalisesti(savellajit, 0);
        assertTrue(suoritus.tehtavaOikein("0"));
        
    }
    
    @Test
    public void tehtavaMeneeVaarin() {
        suoritus.setSuoritettavaManuaalisesti(savellajit, 0);
        assertFalse(suoritus.tehtavaOikein("4"));
    }
    
    @Test
    public void vainNumeroKelpaa() {
        suoritus.setSuoritettavaManuaalisesti(savellajit, 0);
        assertFalse(suoritus.tehtavaOikein("kissa"));
    }
}
