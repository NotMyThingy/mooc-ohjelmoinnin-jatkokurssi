package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Nakymat extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button nappi1 = new Button("Tokaan näkymään!");
        Button nappi2 = new Button("Kolmanteen näkymään!");
        Button nappi3 = new Button("Ekaan näkymään!");

        BorderPane layout1 = new BorderPane();
        layout1.setTop(new Label("Eka näkymä!"));
        layout1.setCenter(nappi1);

        VBox layout2 = new VBox();
        layout2.getChildren().add(nappi2);
        layout2.getChildren().add(new Label("Toka näkymä!"));

        GridPane layout3 = new GridPane();
        layout3.add(new Label("Kolmas näkymä!"), 0, 0);
        layout3.add(nappi3, 1, 1);

        Scene scene1 = new Scene(layout1);
        Scene scene2 = new Scene(layout2);
        Scene scene3 = new Scene(layout3);

        nappi1.setOnAction((event) -> stage.setScene(scene2));
        nappi2.setOnAction((event) -> stage.setScene(scene3));
        nappi3.setOnAction((event) -> stage.setScene(scene1));

        stage.setScene(scene1);
        stage.show();
    }
}
