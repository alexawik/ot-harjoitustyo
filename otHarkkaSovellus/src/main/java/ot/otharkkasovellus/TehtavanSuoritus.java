package ot.otharkkasovellus;


public class TehtavanSuoritus {
    private Kayttaja kayttaja;
    private Tehtava tehtava;
  
    public TehtavanSuoritus(Kayttaja kayttaja, Tehtava tehtava) {
        this.kayttaja = kayttaja;
        this.tehtava = tehtava;
    }


    public Boolean kysymysOikein(String kysymys, String kayttajanVastaus) {
        if (tehtava.kysymykset().get(kysymys).equals(kayttajanVastaus)) {
            kayttaja.lisaaPisteita(1);
            return true;
        } else {
            return false;
        }
    }
}
