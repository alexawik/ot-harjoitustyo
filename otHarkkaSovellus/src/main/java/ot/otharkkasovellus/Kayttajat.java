
package ot.otharkkasovellus;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hallinnoi sovelluksen käyttäjiä
 */
public class Kayttajat {
    private List<Kayttaja> kayttajat;
    private String file;
    
    public Kayttajat(String file) throws Exception {
        this.kayttajat = new ArrayList<>();
        this.file = file;
        try {
            Scanner lukija = new Scanner(new File(file));
            while (lukija.hasNextLine()) {
                String[] tiedot = lukija.nextLine().split("\t");
                Kayttaja kayttaja = new Kayttaja(tiedot[0], tiedot[1], 0);
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
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Kayttaja kayttaja : kayttajat) {
                writer.write(kayttaja.getNimi() + "\t" + kayttaja.getSalasana() + kayttaja.getPistemaara() + "\n");
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
     * @return käyttäjä jos löytyy, muuten null
     */
    public Kayttaja loytyykoKayttaja(Kayttaja kayttaja) {
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
            nimet.add(kayttajat.get(i).getNimi());
        }
        return nimet;
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
