package ristinolla;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RistinollaSovellus extends Application {

	@Override
	public void start(Stage stage) {
		Ristinolla ristinolla = new Ristinolla();

		Font font = Font.font("Monospaced", 40);

		Label pelitilanne = new Label("Vuoro: " + ristinolla.vuoro());
		pelitilanne.setPadding(new Insets(0, 30, 0, 30));
		pelitilanne.setFont(font);

		BorderPane layout = new BorderPane();
		layout.setPrefSize(300, 300);
		layout.setTop(pelitilanne);

		GridPane peliruudukko = new GridPane();
		peliruudukko.setHgap(10);
		peliruudukko.setVgap(10);
		peliruudukko.setPadding(new Insets(10, 30, 30, 30));

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				Button button = new Button(ristinolla.status(x, y));
				button.setFont(font);

				peliruudukko.add(button, x, y);

				int rx = x;
				int ry = y;

				button.setOnMouseClicked((event) -> {
					ristinolla.setMark(rx, ry);
					button.setText(ristinolla.status(rx, ry));
					pelitilanne.setText("Vuoro: " + ristinolla.vuoro());

					if (ristinolla.loppu()) {
						pelitilanne.setText("Loppu!");

						for (Node node : peliruudukko.getChildren()) {
							Button btn = (Button) node;
							btn.setDisable(true);
						}
					}
				});
			}
		}

		layout.setCenter(peliruudukko);
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
	}


	/*private void lukitseRuudukko() {
		for (Node node : peliruudukko.getChildren()) {
			Button button = (Button) node;
			button.setDisable(true);
		}
	}*/

	public static void main(String[] args) {
		Application.launch();
	}

}