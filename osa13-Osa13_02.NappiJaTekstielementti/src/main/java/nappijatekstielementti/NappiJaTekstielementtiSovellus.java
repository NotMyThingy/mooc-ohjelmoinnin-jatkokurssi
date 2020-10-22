package nappijatekstielementti;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstielementtiSovellus extends Application {


    public static void main(String[] args) {
        launch(NappiJaTekstielementtiSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("PAINA MUA");
        Label label = new Label("Tää ei tee mitään!");

        FlowPane components = new FlowPane();
        components.getChildren().add(button);
        components.getChildren().add(label);

        Scene scene = new Scene(components);

        stage.setScene(scene);
        stage.show();
    }
}
