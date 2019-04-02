package ot.otharkkasovellus;


import java.util.HashMap;


public class Tehtava {
    private String kuvaus;
    private HashMap<String,String> kysymyksetVastaukset;
    
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public String getKuvaus() {
        return this.kuvaus;
    }

    public void uusiKysymys(String kysymys, String vastaus) {
        String k = kysymys;
        String v = vastaus;
        kysymyksetVastaukset.putIfAbsent(k, v);
    }
    
    public void poistaKysymys(String kysymys) {
        kysymyksetVastaukset.remove(kysymys);
    }
    public HashMap<String,String> kysymykset() {
        return kysymyksetVastaukset;
        
    }    
        
}
