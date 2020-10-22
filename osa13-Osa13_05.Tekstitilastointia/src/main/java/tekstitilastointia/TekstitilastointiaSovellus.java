package tekstitilastointia;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TekstitilastointiaSovellus extends Application {


    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();

        TextArea textArea = new TextArea();

        HBox textComponents = new HBox();
        textComponents.setSpacing(10);
        textComponents.getChildren().add(new Label("Kirjaimia: 0"));
        textComponents.getChildren().add(new Label("Sanoja: 0"));
        textComponents.getChildren().add(new Label("Pisin sana on:"));

        pane.setCenter(textArea);
        pane.setBottom(textComponents);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
