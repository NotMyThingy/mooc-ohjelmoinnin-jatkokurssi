package tekstitilastointia;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TekstitilastointiaSovellus extends Application {


    public static void main(String[] args) {
        launch(TekstitilastointiaSovellus.class);
    }

    @Override
    public void start(Stage stage) {
        int kirjaimia = 0;
        int sanoja = 0;
        String pisinSana = "";

        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();
        layout.setCenter(textArea);
        HBox statistics = new HBox();
        layout.setBottom(statistics);

        Label letters = new Label();
        Label words = new Label();
        Label tallestWord = new Label();

        statistics.getChildren().add(letters);
        statistics.getChildren().add(words);
        statistics.getChildren().add(tallestWord);

        textArea.textProperty().addListener((muutos, vanhaArvo, uusiArvo) -> {
            int letterCount = uusiArvo.length();
            String[] wordSplit = uusiArvo.split(" ");
            int wordCount = wordSplit.length;
            String tallest = Arrays.stream(wordSplit)
                    .sorted((w1, w2) -> w2.length() - w1.length())
                    .findFirst()
                    .get();

            letters.setText("Kirjaimia: " + letterCount);
            words.setText("Sanoja: " + wordCount);
            tallestWord.setText("Pisin sana on: " + tallest);
        });

        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.show();
    }
}
