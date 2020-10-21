package ilmoitin;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IlmoitinSovellus extends Application {


    public static void main(String[] args) {
        launch(IlmoitinSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();
        Button updateButton = new Button("Update");
        Label resultLabel = new Label();

        updateButton.setOnAction((event) -> resultLabel.setText(textField.getText()));

        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.getChildren().addAll(textField, updateButton, resultLabel);

        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();
    }
}
