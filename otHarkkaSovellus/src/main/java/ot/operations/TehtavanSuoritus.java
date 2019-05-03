
package ot.operations;

import java.util.regex.*;
import ot.domain.Savellaji;

public class TehtavanSuoritus {
    private Savellajit slajit;
    private Savellaji suoritettava;
    
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
     * Metodi suoritettavan sävellajin manuaaliseen asettamiseen.
     * Avustaa testeissä.
     * 
     * @param slajit sävellaji-lista
     * @param indeksi listan indeksi josta sävellaji halutaan hakea
     */
    public void setSuoritettavaManuaalisesti(Savellajit slajit, int indeksi) {
        this.suoritettava = slajit.getSavellaji(indeksi);
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
        if (Pattern.matches("[0-9]", vastaus)) {
            int etumerkit = Integer.parseInt(vastaus);
            if (suoritettava.getEtumerkkeja() == etumerkit) {
                oikein = true;
            }
        }   
        
        return oikein;
    }
    
}
