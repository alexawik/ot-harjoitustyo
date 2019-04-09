
package ot.otharkkasovellus;

import java.util.ArrayList;
import java.util.List;

public class Kayttajat {
    private List<Kayttaja> kayttajat;

    public Kayttajat() {
        this.kayttajat = new ArrayList<>();
    }
    
    public void lisaaKayttaja(Kayttaja kayttaja) {
        kayttajat.add(kayttaja);
    }
    
}
