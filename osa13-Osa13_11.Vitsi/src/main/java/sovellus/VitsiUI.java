package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VitsiUI extends Application {

    @Override
    public void start(Stage stage) {

        // Main frame
        BorderPane mainframe = new BorderPane();

        // Menu display
        HBox menu = new HBox();

        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button expl = new Button("Explanation");

        menu.getChildren().addAll(joke, answer, expl);
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(15);
        menu.setPadding(new Insets(20));

        mainframe.setBottom(menu);

        // Joke display
        Label jokeStuff = createNewLabel("What do you call a bear with no teeth?");
        Label jokeAnswer = createNewLabel("A gummy bear.");
        Label jokeExpl = createNewLabel("WTF?!!!");

        joke.setOnAction((event) -> mainframe.setCenter(jokeStuff));
        answer.setOnAction((event) -> mainframe.setCenter(jokeAnswer));
        expl.setOnAction((event) -> mainframe.setCenter(jokeExpl));

        // Init setup
        mainframe.setCenter(jokeStuff);

        Scene scene = new Scene(mainframe);

        stage.setScene(scene);
        stage.show();
    }

    private Label createNewLabel(String message) {
        Label label = new Label(message);
        label.setPrefSize(350, 50);
        label.setAlignment(Pos.CENTER);
        label.setPadding(new Insets(30));

        return label;
    }
}
