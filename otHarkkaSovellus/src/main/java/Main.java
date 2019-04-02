
import java.util.Scanner;
import ot.otharkkasovellus.Kayttaja;
import ot.otharkkasovellus.Tehtava;
import ot.otharkkasovellus.TehtavanSuoritus;


// Tällä hetkellä projektissa ei ole vielä toimivaa graafista
// käyttöliittymää, sen muodostaminen on vuorossa seuraavaksi.
// Tämä pääohjelma demonstroi sovelluksen toiminnallisuutta.

public class Main {

    public static void main(String[] args) {
        Kayttaja kayttaja = new Kayttaja("The Dude", "Abides");
        Tehtava tehtava = new Tehtava();
        tehtava.setKuvaus("Montako etumerkkiä on mainituissa sävellajeissa?");
        tehtava.uusiKysymys("F-duuri", "1");
        TehtavanSuoritus suoritus = new TehtavanSuoritus(kayttaja, tehtava);
        Scanner lukija = new Scanner(System.in);
        while (!lukija.nextLine().equals("")) {
            System.out.println(tehtava.getKuvaus());
            System.out.println(tehtava.kysymykset().keySet());
            String vastaus = lukija.nextLine();
            suoritus.kysymysOikein("F-duuri", vastaus);
        }
    }
    
}
