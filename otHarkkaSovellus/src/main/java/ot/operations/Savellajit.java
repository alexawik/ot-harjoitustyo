
package ot.operations;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
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
}
