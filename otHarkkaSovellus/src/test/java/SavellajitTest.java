
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ot.domain.Savellaji;
import ot.operations.Savellajit;

public class SavellajitTest {
    Savellajit savellajit;
    
    @Before
    public void setUp() throws Exception {
        savellajit = new Savellajit("savellajit.txt");
    }
    
    @Test
    public void lukeeTiedostonOikein() {
        assertTrue(savellajit.getSavellaji(0).getNimi().equals("C-duuri"));
    }
    
    @Test
    public void palauttaaSatunnaisenSavellajin() {
        Savellaji satunnainen = savellajit.satunnainenSavellaji();
        assertTrue(satunnainen.getEtumerkkeja()<8);
    }

}
