
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import ot.domain.Kayttaja;
import ot.operations.Kayttajat;

public class KayttajatTest {
    @Rule
    public TemporaryFolder testikansio = new TemporaryFolder();    
    File kayttiedosto;
    Kayttajat kayt;
    
    @Before
    public void setUp() throws Exception {
        kayttiedosto = testikansio.newFile("kayttajat_testi.txt");
       
        try (FileWriter tiedosto = new FileWriter(kayttiedosto.getAbsolutePath())) {
           tiedosto.write("The Dude\tAbides\t0\n");
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
    
    @Test
    public void kayttajaLoytyyBoolean() {
        Kayttaja kayttaja = new Kayttaja("The Dude", "Abides", 0);
        assertTrue(kayt.loytyykoKayttaja(kayttaja));
    }
    
    @Test
    public void kayttajaEiLoydyBoolean() {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        assertFalse(kayt.loytyykoKayttaja(kayttaja));
    }
    
    @Test
    public void kayttajaLoytyyOlio() {
        Kayttaja kayttaja = new Kayttaja("The Dude", "Abides", 0);
        assertTrue(kayt.etsiKayttaja(kayttaja) != null);
    }
    
    @Test
    public void kayttajaEiLoydyOlio() {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        assertTrue(kayt.etsiKayttaja(kayttaja) == null);
    }
    
    @Test
    public void kayttajaLisataan() throws Exception {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        kayt.lisaaKayttaja(kayttaja);
        assertTrue(kayt.loytyykoKayttaja(kayttaja));
    }
    
    @Test
    public void kirjautujaLoytyy() throws Exception {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        kayt.lisaaKayttaja(kayttaja);
        kayt.setKirjautuja(kayttaja);
        assertTrue(kayt.getKirjautuja().equals(kayttaja));
    }
    
    @Test
    public void kayttajatPisteineenLoytyy() throws Exception {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        kayt.lisaaKayttaja(kayttaja);
        List kayttajatpisteineen = kayt.getKayttajatJaPisteet();
        String toinenListalla = kayttajatpisteineen.get(1).toString();
        assertTrue(toinenListalla.equals("Mikko:  0"));
    }
    
    @Test
    public void toStringTulostaaOikein() throws Exception {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        kayt.lisaaKayttaja(kayttaja);
        assertTrue(kayt.toString().equals("The Dude:  0\nMikko:  0\n"));
    }
    
    @Test
    public void pisteitaLisataan() {
        Kayttaja kayttaja = new Kayttaja("Mikko", "kissakoira", 0);
        kayt.setKirjautuja(kayttaja);
        kayt.getKirjautuja().lisaaPisteita(1);
        assertTrue(kayt.getKirjautuja().getPistemaara() == 1);
    }
}
