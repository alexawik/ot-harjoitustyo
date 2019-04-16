
package ot.otharkkasovellus;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                Kayttaja kayttaja = new Kayttaja(tiedot[0], tiedot[1]);
                kayttajat.add(kayttaja);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Kayttaja kayttaja : kayttajat) {
                writer.write(kayttaja.getNimi() + "\t" + kayttaja.getSalasana() + "\n");
            }
        }
    }
    
    public void lisaaKayttaja(Kayttaja kayttaja) throws Exception {
        kayttajat.add(kayttaja);
        save();
    }
    
    public Kayttaja loytyykoKayttaja(Kayttaja kayttaja) {
        return kayttajat.stream()
                .filter(k->k.getNimi()
                .equals(kayttaja.getNimi()))
                .findFirst()
                .orElse(null);
    }
    
    public List<Kayttaja> getKayttajat() {
        return kayttajat;
    }
    
    public List<String> getKayttajanimet() {
        List<String> nimet = new ArrayList();
            for (int i=0;i<kayttajat.size();i++) {
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
