
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


public class Kayttis extends Application{
    
    @Override
        public void start(Stage primaryStage) throws Exception {
            String kayttiedosto = "kayttajat.txt";
            Kayttajat kayttajat = new Kayttajat(kayttiedosto);
            // etusivu
            BorderPane layout = new BorderPane();
            FlowPane pane1 = new FlowPane();
            Label label1= new Label("Kirjaudu");
            label1.setFont(new Font("Arial", 14));
            label1.setPadding(new Insets(2, 2, 8, 2));
            Button b1 = new Button("Käyttäjä");
            Button b2 = new Button("Uusi käyttäjä");
            Button b3 = new Button("Admin");
            VBox set1 = new VBox(label1, b1, b2, b3);
            
            set1.setSpacing(10);
            pane1.getChildren().add(set1);
            pane1.setPadding(new Insets(60, 0, 0, 210));
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
            Text text1 = new Text(kayttajat.toString());
            VBox set7 = new VBox(text1);
            pane5.getChildren().add(set7);
            
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
               //kirjautuminen 
               
            });
            
            b5.setOnAction((event) ->  {
                //paluunappi
                layout.setCenter(pane1);
            });
            
            b6.setOnAction((event) -> {
                //uuden käyttäjän lisääminen
                Kayttaja uusikayttaja = new Kayttaja(field3.getText(), field4.getText(), 0);
                if (kayttajat.loytyykoKayttaja(uusikayttaja) == null) {
                    try {
                        kayttajat.lisaaKayttaja(uusikayttaja);
                    } catch (Exception ex) {
                        Logger.getLogger(Kayttis.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });
            
            b7.setOnAction((event) -> {
                //paluunappi
               layout.setCenter(pane1); 
            });
            
            b8.setOnAction((event) -> {
               //admin-kirjautminen
               if (field5.getText().equals("admin")) {
                   layout.setCenter(pane5);                   
               }
            });
            
            b9.setOnAction((event) -> {
                //paluunappi
               layout.setCenter(pane1);
            });
            
            
            
        }
        
        public static void main(String[] args) {
        launch(Kayttis.class);
        
    } 
}
