
import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import com.mycompany.unicafe.Paaohjelma;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import sun.applet.Main;

public class KassapaateTest {
    Paaohjelma paaohjelma;
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti2;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(500);
        kortti2 = new Maksukortti(100);
    }
    
    @Test
    public void kassassaOikeaMaara() {
        assertTrue(kassa.kassassaRahaa()==100000);
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void edullistenKateisostoToimii() {
        assertTrue(kassa.syoEdullisesti(300)==60);
        assertTrue(kassa.kassassaRahaa()==100240);
        
    }
    
    @Test
    public void maukkaidenKateisostoToimii() {
        assertTrue(kassa.syoMaukkaasti(500)==100);
        assertTrue(kassa.kassassaRahaa()==100400);
    }
    
    @Test 
    public void myytyjenLounaidenMaaraKasvaaEdullisesti() {
        kassa.syoEdullisesti(240);
        assertTrue(kassa.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaMaukkaasti() {
        kassa.syoMaukkaasti(400);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==1);
    }

    @Test
    public void rahatPalautetaanJosEiRiittavaEdullisesti() {
        assertTrue(kassa.syoEdullisesti(200)==200);
        assertTrue(kassa.kassassaRahaa()==100000);
        assertTrue(kassa.edullisiaLounaitaMyyty()==0);
    }
    
    @Test
    public void rahatPalautetaanJosEiRiittavaMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(200)==200);
        assertTrue(kassa.kassassaRahaa()==100000);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==0);
    }
    
    @Test
    public void korttiostoEdullisestiToimii() {    
        assertTrue(kassa.syoEdullisesti(kortti)==true);
    }
    
    @Test
    public void korttiostoMaukkaastiToimii() {
        assertTrue(kassa.syoMaukkaasti(kortti)==true);
    }
    
    @Test
    public void korttiostoNostaaEdullisestiMaaraa() {
        assertTrue(kassa.syoEdullisesti(kortti)==true);
        assertTrue(kassa.edullisiaLounaitaMyyty()==1);
    }
    
    @Test
    public void korttiostoNostaaMaukkaastiMaaraa() {
        assertTrue(kassa.syoMaukkaasti(kortti)==true);
        assertTrue(kassa.maukkaitaLounaitaMyyty()==1);
    }
    
    @Test
    public void rahatPysyyKortillaJosEiRiittavaEdullisesti() {
        assertTrue(kassa.syoEdullisesti(kortti2)==false);
        assertTrue(kortti2.saldo()==100);
    }
    
    @Test
    public void rahatPysyyKortillaJosEiRiittavaMaukkaasti() {
        assertTrue(kassa.syoMaukkaasti(kortti2)==false);
        assertTrue(kortti2.saldo()==100);
    }

    @Test
    public void korttiostoEiMuutaKassanRahamaaraaEdullisesti() {
        kassa.syoEdullisesti(kortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void korttiostoEiMuutaKassanRahamaaraaMaukkaasti() {
        kassa.syoMaukkaasti(kortti);
        assertTrue(kassa.kassassaRahaa()==100000);
    }
    
    @Test
    public void kortilleLatausToimii() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals("saldo: 10.0", kortti.toString());
        assertTrue(kassa.kassassaRahaa()==100500);
    }
    
    @Test
    public void negatiivinenLatausEiToimi() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertTrue(kortti.saldo()==500);
    }

}
