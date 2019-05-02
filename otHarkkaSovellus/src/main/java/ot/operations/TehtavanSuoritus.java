
package ot.operations;

import ot.domain.Kayttaja;
import ot.domain.Savellaji;

public class TehtavanSuoritus {
    private Savellajit slajit;
    private Savellaji suoritettava;
    
    public TehtavanSuoritus() {
    }
    
    /**
     * Asettaa tehtävään suoritettavan sävellajin
     * sävellaji-listasta
     * 
     * @param slajit
     */
    public void setSuoritettava(Savellajit slajit) {
        this.suoritettava = slajit.satunnainenSavellaji();
    }
    
    /**
     * Kertoo, mikä satunnainen sävellaji on suoritettavana
     * 
     * @return Savellaji-olio 
     */
    public Savellaji getSuoritettava() {
        return this.suoritettava;
    }
   
    /**
     * Kertoo, vastaako etumerkkien määrän oikeaa määrää.
     * 
     * @param vastaus käyttäjän antama vastaus
     * 
     * @return True jos vastaus oikein, muuten false.
     */
    public Boolean tehtavaOikein(String vastaus) {
        Boolean oikein = false;
        int etumerkit = Integer.parseInt(vastaus);
        if (suoritettava.getEtumerkkeja() == etumerkit) {
            oikein = true;
        }
        
        return oikein;
    }
    
}
