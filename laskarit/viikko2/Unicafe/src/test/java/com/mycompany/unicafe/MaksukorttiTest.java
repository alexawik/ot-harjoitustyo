package com.mycompany.unicafe;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
       assertTrue(kortti.saldo()==10.0);
    }
    
    @Test
    public void lataaminenKasvattaaOikein() {
        kortti.lataaRahaa(4);
        assertTrue(kortti.saldo()==14.0);
    }
    
    @Test
    public void saldoVaheneeKunRahaaTarpeeksi() {
        kortti.otaRahaa(9);
        assertThat(kortti.saldo()==1.0, is(true));
    }
    
    @Test
    public void saldoMuuttuuOikein() {
        kortti.otaRahaa(11);
        assertThat(kortti.saldo()==10.0, is(true));
    }
}
