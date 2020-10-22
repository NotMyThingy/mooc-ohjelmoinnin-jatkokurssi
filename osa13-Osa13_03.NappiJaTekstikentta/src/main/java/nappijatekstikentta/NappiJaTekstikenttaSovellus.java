package nappijatekstikentta;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class NappiJaTekstikenttaSovellus extends Application {


    public static void main(String[] args) {
        launch(NappiJaTekstikenttaSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        Button button = new Button("button");
        TextField textField = new TextField();

        FlowPane pane = new FlowPane();
        pane.getChildren().add(button);
        pane.getChildren().add(textField);

        Scene dontMakeAScene = new Scene(pane);

        stage.setScene(dontMakeAScene);
        stage.show();
    }
}
