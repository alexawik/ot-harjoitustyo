
package ot.domain;

public class Savellaji {
    private String nimi;
    private int etumerkkeja;
    
    public Savellaji(String nimi, int etumerkkeja) {
        this.nimi = nimi;
        this.etumerkkeja = etumerkkeja;
    }

    public String getNimi() {
        return nimi;
    }

    public int getEtumerkkeja() {
        return etumerkkeja;
    }
    
    @Override
    public String toString() {
        return nimi + ", " + etumerkkeja + " etumerkkiä";
    }
}
