
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import ot.otharkkasovellus.Kayttaja;
import ot.otharkkasovellus.Kayttajat;

public class KayttajatTest {
    @Rule
    public TemporaryFolder testikansio = new TemporaryFolder();    
    File kayttiedosto;
    Kayttajat kayt;
    
    @Before
    public void setUp() throws Exception {
        kayttiedosto = testikansio.newFile("kayttajat_testi.txt");
       
        try (FileWriter tiedosto = new FileWriter(kayttiedosto.getAbsolutePath())) {
           tiedosto.write("The Dude\tAbides\n");
        }
       
        kayt = new Kayttajat(kayttiedosto.getAbsolutePath());
    }
    

    @Test
    public void tiedostonLukeminenOnnistuu() {
        List<Kayttaja> kaytlista = kayt.getKayttajat();
        Kayttaja kayttaja = kaytlista.get(0);
        assertTrue(kaytlista.size() == 1);
        assertTrue("The Dude".equals(kayttaja.getNimi()));
        assertTrue("Abides".equals(kayttaja.getSalasana()));
    }
}
