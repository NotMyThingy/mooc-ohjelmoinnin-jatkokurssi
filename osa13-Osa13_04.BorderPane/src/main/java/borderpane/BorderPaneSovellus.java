package borderpane;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneSovellus extends Application {


    public static void main(String[] args) {
        launch(BorderPaneSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        Label label_north = new Label("NORTH");
        Label label_east = new Label("EAST");
        Label label_south = new Label("SOUTH");

        BorderPane pane = new BorderPane();
        pane.setTop(label_north);
        pane.setRight(label_east);
        pane.setBottom(label_south);

        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
}
