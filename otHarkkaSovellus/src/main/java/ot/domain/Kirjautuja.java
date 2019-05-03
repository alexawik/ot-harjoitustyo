package ot.domain;


public class Kirjautuja {
    private String kayttajatunnus;
    private String salasana;

    public Kirjautuja(String tunnus, String salasana) {
        this.kayttajatunnus = tunnus;
        this.salasana = salasana;
    }
    public String getKayttajatunnus() {
        return kayttajatunnus;
    }

    public String getSalasana() {
        return salasana;
    } 
    
}
