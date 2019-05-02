
package ot.operations;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ot.domain.Kayttaja;

/**
 * Hallinnoi sovelluksen käyttäjiä
 */
public class Kayttajat {
    private List<Kayttaja> kayttajat;
    private String file;
    private Kayttaja kirjautuja;
    
    public Kayttajat(String file) throws Exception {
        this.kayttajat = new ArrayList<>();
        this.file = file;
        try {
            Scanner lukija = new Scanner(new File(file));
            while (lukija.hasNextLine()) {
                String[] tiedot = lukija.nextLine().split("\t");
                Kayttaja kayttaja = new Kayttaja(tiedot[0], tiedot[1], Integer.parseInt(tiedot[2]));
                kayttajat.add(kayttaja);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    /**
     * Lisää käyttäjän tekstitiedostoon
     * 
     * @throws Exception 
     */
    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Kayttaja kayttaja : kayttajat) {
                writer.write(kayttaja.getNimi() + "\t" + kayttaja.getSalasana() + "\t" + kayttaja.getPistemaara() + "\n");
            }
        }
    }
    
    /**
     * Lisää käyttäjän listaan sekä tekstitiedostoon
     * 
     * @param kayttaja Lisättävä käyttäjä
     * 
     * @throws Exception 
     */
    public void lisaaKayttaja(Kayttaja kayttaja) throws Exception {
        kayttajat.add(kayttaja);
        save();
    }
    
    /**
     * Etsii käyttäjistä konstruktorissa annettua käyttäjää
     * 
     * @param kayttaja etsitty käyttäjä
     * 
     * @return true jos löytyy, muuten false
     */
    public boolean loytyykoKayttaja(Kayttaja kayttaja) {
        int k = 0;
        boolean loytyyko = false;
        for (int i = 0; i < kayttajat.size(); i++) {
            if (kayttajat.get(i).getNimi().equals(kayttaja.getNimi())) {
                k++;
            } 
        }
        
        if (k != 0) {
            loytyyko = true;
        }
        
        return loytyyko;
    }
    
    /**
     * Etsii ja palauttaa parametrina annetun käyttäjän
     * 
     * @param kayttaja
     * 
     * @return Käyttäjälistasta löytyvä Kayttaja-olio
     */
    public Kayttaja etsiKayttaja(Kayttaja kayttaja) {
        return kayttajat.stream()
                .filter(k->k.getNimi()
                .equals(kayttaja.getNimi()))
                .findFirst()
                .orElse(null);
    }
    
    /**
    * Palauttaa listan Kayttaja-olioita
    * 
    * @return lista käyttäjistä 
    */
    public List<Kayttaja> getKayttajat() {
        return kayttajat;
    }
    
    /**
     * Listaa käyttäjien nimet
     * 
     * @return lista käyttäjänimistä 
     */
    public List<String> getKayttajanimet() {
        List<String> nimet = new ArrayList();
        for (int i = 0; i < kayttajat.size(); i++) {
            nimet.add(kayttajat.get(i).getNimi() + ":  " + kayttajat.get(i).getPistemaara());
        }
        return nimet;
    }
    
    /**
     * Asettaa konstruktorissa annetun käyttäjän ohjelman kirjautujaksi
     * 
     * @param kayttaja 
     */
    public void setKirjautuja(Kayttaja kayttaja) {
        this.kirjautuja = kayttaja;
    }
    
    /**
     * Hakee käyttäjän joka on kirjautuneena ohjelmaan
     * 
     * @return kayttaja-olio 
     */
    public Kayttaja getKirjautuja() {
        return this.kirjautuja;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : getKayttajanimet()) {
            sb.append(s);
            sb.append("\n");
        }
        
        String kayttajalista = sb.toString();
        
        return kayttajalista;
    }
    
}
