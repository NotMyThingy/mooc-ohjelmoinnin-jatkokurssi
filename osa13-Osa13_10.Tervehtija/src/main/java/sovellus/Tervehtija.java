package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tervehtija extends Application {

    @Override
    public void start(Stage stage) {

        // Aloitusnäkymä
        Label ohjeteksti = new Label("Kirjoita nimesi ja aloita.");
        TextField nimikentta = new TextField();
        Button aloitusButton = new Button("Aloita");

        GridPane aloitusLayout = new GridPane();
        aloitusLayout.add(ohjeteksti, 0, 0);
        aloitusLayout.add(nimikentta, 0, 1);
        aloitusLayout.add(aloitusButton, 0, 2);

        aloitusLayout.setPrefSize(300, 180);
        aloitusLayout.setAlignment(Pos.CENTER);
        aloitusLayout.setVgap(15);
        aloitusLayout.setHgap(15);
        aloitusLayout.setPadding(new Insets(20));

        Scene aloitusScene = new Scene(aloitusLayout);

        // Tervehdysnäkymä
        Label tervehdysteksti = new Label("");

        FlowPane tervehdysLayout = new FlowPane();
        tervehdysLayout.setPrefSize(300, 180);
        tervehdysLayout.getChildren().add(tervehdysteksti);
        tervehdysLayout.setAlignment(Pos.CENTER);

        Scene tervetuloaScene = new Scene(tervehdysLayout);

        aloitusButton.setOnAction((event) -> {
            tervehdysteksti.setText("Tervetuloa " + nimikentta.getText() + "!");
            stage.setScene(tervetuloaScene);
        });

        stage.setScene(aloitusScene);
        stage.show();
    }
}
