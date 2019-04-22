package ot.otharkkasovellus;


public class Kayttaja extends Kirjautuja {
    private int pistemaara;

    
    public Kayttaja(String kayttajatunnus, String salasana, int pistemaara) {
        super(kayttajatunnus, salasana);
        this.pistemaara = 0;        
    }
    
    /**
     * Lisää käyttäjille pisteitä konstruktorissa annetun määrän verran.
     * 
     * @param maara Lisättävien pisteiden määrä 
     */
    public void lisaaPisteita(int maara) {
        pistemaara += maara;
    }
    
    /**
     * Kertoo käyttäjän pistemäärän.
     * 
     * @return käyttäjän pistemäärä 
     */
    public int getPistemaara() {
        return this.pistemaara;
    }
    
    /**
     * Palauttaa käyttäjän nimen
     * 
     * @return käyttäjänimi
     */
    public String getNimi() {
        return super.getKayttajatunnus();
    }
    
    /**
     * Palauttaa käyttäjän salasanan
     * 
     * @return käyttäjän salasana 
     */
    @Override
    public String getSalasana() {
        return super.getSalasana();
    }
 
    @Override
    public String toString() {
        return super.getKayttajatunnus();
    }
}
