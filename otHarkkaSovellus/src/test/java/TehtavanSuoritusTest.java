

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ot.otharkkasovellus.Kayttaja;
import ot.otharkkasovellus.Tehtava;
import ot.otharkkasovellus.TehtavanSuoritus;

public class TehtavanSuoritusTest {
    
    public TehtavanSuoritusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public static void pisteitalisataan() {
        Kayttaja k = new Kayttaja("Dude", "Abides");
        Tehtava t = new Tehtava();
        TehtavanSuoritus ts = new TehtavanSuoritus(k,t);
        assertTrue(ts.kysymysOikein("a", "b"));
        assertTrue(k.getPistemaara()==1);
    }
}
