
package ot.operations;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import ot.domain.Savellaji;

public class Savellajit {
    private List<Savellaji> savellajit;
    private String file;
    
    public Savellajit(String file) throws Exception {
        this.savellajit = new ArrayList<>();
        this.file = file;
        try {
            Scanner lukija = new Scanner(new File(file));
            while (lukija.hasNextLine()) {
                String[] tiedot = lukija.nextLine().split("\t");
                Savellaji savellaji = new Savellaji(tiedot[0], Integer.parseInt(tiedot[1]));
                savellajit.add(savellaji);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    public Savellaji getSavellaji(int i) {
        return savellajit.get(i);
    }
    
    /**
     * Hakee sävellaji-listasta satunnaisen sävellajin
     * 
     * @return Savellaji-olio
     */
    public Savellaji satunnainenSavellaji() {
        Random rndm = new Random();
        int r = rndm.nextInt(savellajit.size());
        
        return savellajit.get(r);
    }
}
