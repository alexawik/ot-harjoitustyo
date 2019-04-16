package ot.otharkkasovellus;


public class Kayttaja extends Kirjautuja {
    private int pistemaara;

    
    public Kayttaja(String kayttajatunnus, String salasana) {
        super(kayttajatunnus, salasana);
        this.pistemaara = 0;        
    }
    
    public void lisaaPisteita(int maara) {
        pistemaara += maara;
    }
    
    public int getPistemaara() {
        return this.pistemaara;
    }
    
    public String getNimi() {
        return super.getKayttajatunnus();
    }
    
    @Override
    public String getSalasana() {
        return super.getSalasana();
    }
 
    @Override
    public String toString() {
        return super.getKayttajatunnus();
    }
}
