
package ot.otharkkasovellus;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ot.domain.Kayttaja;
import ot.operations.Kayttajat;
import ot.operations.Savellajit;
import ot.operations.TehtavanSuoritus;


public class Kayttis extends Application {
    private final String kayttiedosto = "kayttajat.txt";
    private final String saveltiedosto = "savellajit.txt";
    private Kayttajat kayttajat;
    private Savellajit savellajit;
    private TehtavanSuoritus suoritus;
            
    @Override
    public void init() throws Exception {
        
        kayttajat = new Kayttajat(kayttiedosto);
        savellajit = new Savellajit(saveltiedosto);
        suoritus = new TehtavanSuoritus();
        suoritus.setSuoritettava(savellajit);
    }
    
    @Override
        public void start(Stage primaryStage) throws Exception {
            
            // etusivu
            BorderPane layout = new BorderPane();
            FlowPane pane1 = new FlowPane();
            Label otsikko = new Label("Etumerkkiharjoittelua");
            otsikko.setFont(new Font("Arial", 16));
            otsikko.setPadding(new Insets(20, 5, 5, 20));
            Label label1= new Label("Kirjaudu");
            label1.setFont(new Font("Arial", 14));
            label1.setPadding(new Insets(2, 2, 8, 2));
            Button b1 = new Button("Käyttäjä");
            Button b2 = new Button("Uusi käyttäjä");
            Button b3 = new Button("Admin");           
            VBox set1 = new VBox(label1, b1, b2, b3);
            set1.setPadding(new Insets(60, 0, 0, 20));
            HBox etunakyma = new HBox(otsikko, set1);
            etunakyma.setSpacing(10);
            
            set1.setSpacing(10);
            pane1.getChildren().addAll(etunakyma);
            //pane1.setPadding(new Insets(60, 0, 0, 210));
            layout.setCenter(pane1);
            
            Scene scene1 = new Scene(layout, 500, 300);
            primaryStage.setScene(scene1);
            primaryStage.show();
            
            // Kirjautumissivu
            
            FlowPane pane2 = new FlowPane();
            Label label2 = new Label("Nimi");
            label2.setPadding(new Insets(2));
            TextField field1 = new TextField();
            HBox hbox1 = new HBox(label2, field1);
            hbox1.setPadding(new Insets(0, 0, 10, 0));
            
            Label label3 =new Label("Salasana");
            label3.setPadding(new Insets(2));
            TextField field2 = new TextField();
            HBox hbox2 = new HBox(label3, field2);
            hbox2.setPadding(new Insets(0, 0, 10, 0));
            Button b4 = new Button("Kirjaudu");
            Button b5 = new Button("Takaisin");
            VBox set2 = new VBox(b4, b5);
            set2.setSpacing(7);
            VBox set3 = new VBox(hbox1, hbox2, set2);
            pane2.getChildren().add(set3);
            pane2.setPadding(new Insets(70, 0, 0, 170));
            
            // Uuden käyttäjän luominen
            
            FlowPane pane3 = new FlowPane();
            Label label4 = new Label("Nimi");
            label4.setPadding(new Insets(2));
            TextField field3 = new TextField();
            HBox hbox4 = new HBox(label4, field3);
            hbox4.setPadding(new Insets(0, 0, 10, 0));
            
            Label label5 =new Label("Salasana");
            label5.setPadding(new Insets(2));
            TextField field4 = new TextField();
            HBox hbox5 = new HBox(label5, field4);
            hbox5.setPadding(new Insets(0, 0, 10, 0));
            Button b6 = new Button("Lisää uusi käyttäjä");
            Button b7 = new Button("Takaisin");
            VBox set4 = new VBox(b6, b7);
            set4.setSpacing(7);
            VBox set5 = new VBox(hbox4, hbox5, set4);
            pane3.getChildren().add(set5);
            pane3.setPadding(new Insets(70, 0, 0, 170));
            
            //admin-kirjautumissivu
            
            FlowPane pane4 = new FlowPane();
            Label label6 = new Label("Syötä admin-salasana:");
            TextField field5 = new TextField();
            Button b8 = new Button("Kirjaudu");
            Button b9 = new Button("Takaisin");
            VBox set6 = new VBox(label6, field5, b8, b9);
            set6.setSpacing(7);
            pane4.getChildren().add(set6);
            pane4.setPadding(new Insets(70, 0, 0, 170));
            
            //admin-sivu
            FlowPane pane5 = new FlowPane();
            Label label7 = new Label("Käyttäjien pisteet");
            label7.setFont(new Font("Arial", 14));
            label7.setPadding(new Insets(2, 2, 8, 2));
            Button b13 = new Button("Takaisin");
            Text text1 = new Text(kayttajat.toString());
            VBox set7 = new VBox(label7, text1, b13);
            set7.setSpacing(5);
            set7.setPadding(new Insets(10, 2, 2, 20));
            pane5.setPadding(new Insets(2, 2, 2, 2));
            pane5.getChildren().add(set7);
            
            //käyttäjä-sivu
            FlowPane pane6 = new FlowPane();
            Text text2 = new Text();
            Text text3 = new Text();
            Button b10 = new Button("Harjoitukseen");
            Button b11 = new Button("Takaisin");
            VBox set8 = new VBox(text2, text3, b11);
            VBox set9 = new VBox(b10);
            set8.setSpacing(5);
            set9.setPadding(new Insets(120, 0, 0, 90));
            pane6.setPadding(new Insets(2, 2, 2, 2));
            pane6.getChildren().addAll(set8, set9);
            
            //tehtävä-sivu
            FlowPane pane7 = new FlowPane();
            Button b12 = new Button("Takaisin");
            Text text4 = new Text("Montako etumerkkiä on annetussa sävellajissa?");
            Text text5 = new Text(suoritus.getSuoritettava().getNimi());
            TextField field6 = new TextField();            
            Button b14 = new Button("Vastaa");
            Text text6 = new Text();
            Text text7 = new Text();
            Text text8 = new Text();
            HBox hbox6 = new HBox(text5, field6, b14);
            hbox6.setSpacing(5);
            VBox set10 = new VBox(text4, hbox6, text8);
            set10.setSpacing(10);
            VBox set11 = new VBox(text6, text7, b12);
            set11.setSpacing(5);
            set10.setPadding(new Insets(100, 0, 0, 60));
            pane7.setPadding(new Insets(2, 2, 2, 2));
            pane7.getChildren().addAll(set11, set10);
            
            b1.setOnAction((event) -> {
                //siirtyminen vanhan käyttäjän kirjautumiseen
                layout.setCenter(pane2);
            });
            
            b2.setOnAction((event) -> {
                //siirtyminen uuden käyttäjän luontiin
                layout.setCenter(pane3);
            });
            
            b3.setOnAction((event) -> {
                //siirtyminen admin-kirjautumiseen
                layout.setCenter(pane4); 
            });
            
            b4.setOnAction((event) -> {
                //käyttäjän kirjautuminen
                Kayttaja kayttajako = new Kayttaja(field1.getText(), field2.getText(), 0);
                if (kayttajat.loytyykoKayttaja(kayttajako)) {
                    kayttajat.setKirjautuja(kayttajat.etsiKayttaja(kayttajako));
                    layout.setCenter(pane6);
                    text2.setText("Kirjautuneena: " + kayttajat.getKirjautuja().getNimi());
                    text3.setText("Pisteitä: " + kayttajat.getKirjautuja().getPistemaara());
                }           
            });
                       
            b5.setOnAction((event) ->  {
                //paluunappi kirjautumisesta
                layout.setCenter(pane1);
                field1.clear();
                field2.clear();
                
            });
            
            b6.setOnAction((event) -> {
                //uuden käyttäjän lisääminen
                Kayttaja uusikayttaja = new Kayttaja(field3.getText(), field4.getText(), 0);
                if (!kayttajat.loytyykoKayttaja(uusikayttaja)) {
                    try {
                        kayttajat.lisaaKayttaja(uusikayttaja);
                    } catch (Exception ex) {
                        Logger.getLogger(Kayttis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                layout.setCenter(pane2);
                text1.setText(kayttajat.toString());
            });
            
            b7.setOnAction((event) -> {
                //paluunappi käyttäjän luonnista
               layout.setCenter(pane1); 
               field3.clear();
               field4.clear();
            });
            
            b8.setOnAction((event) -> {
               //admin-kirjautminen
                if (field5.getText().equals("admin")) {
                   layout.setCenter(pane5);
                   text1.setText(kayttajat.toString());
                }
            });
            
            b9.setOnAction((event) -> {
                //paluunappi admin-kirjautumisesta
               layout.setCenter(pane1);
               field5.clear();
            });
            
            b10.setOnAction((event) -> {
               //siirtyminen harjoitukseen
               layout.setCenter(pane7);
               text5.setText(suoritus.getSuoritettava().getNimi());
               text6.setText(text2.getText());
               text7.setText(text3.getText());
            });
            
            b11.setOnAction((event) -> {
               //paluunappi käyttäjän sivulta
               layout.setCenter(pane2);
            });
            
            b12.setOnAction((event) -> {
               //paluunappi harjoituksesta
               layout.setCenter(pane6);
               field6.clear();
               text3.setText("Pisteitä: " + kayttajat.getKirjautuja().getPistemaara());
            });
            
            b13.setOnAction((event) -> {
               //paluunappi admin-näkymästä
               layout.setCenter(pane4);
            });
            
            b14.setOnAction((event) -> {
                //tehtävään vastaaminen 
                if (suoritus.tehtavaOikein(field6.getText())) {
                    kayttajat.getKirjautuja().lisaaPisteita(1);
                    suoritus.setSuoritettava(savellajit);
                    text8.setText("Oikein!");
                    text7.setText("Pisteitä: " + kayttajat.getKirjautuja().getPistemaara());
                    text5.setText(suoritus.getSuoritettava().getNimi());
                } else {
                    text8.setText("Yritä uudelleen.");
                }
                field6.clear();
                field6.requestFocus();
            });
        }
        
        public static void main(String[] args) {
        launch(Kayttis.class);
        
    }
        
    @Override
    public void stop() throws Exception {
        kayttajat.save();
    }   
}
