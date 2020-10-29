package ristinolla;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UI extends Application {

	private String vuoro;

	@Override
	public void init() {
		this.vuoro = "X";
	}

	@Override
	public void start(Stage stage) {

		BorderPane layout = new BorderPane();

		Label pelitilanne = new Label("Vuoro: " + vuoro);
		pelitilanne.setPadding(new Insets(10, 30, 0, 30));
		pelitilanne.setFont(Font.font("Monospaced", 40));

		layout.setTop(pelitilanne);

		GridPane peliruudukko = new GridPane();
		peliruudukko.setHgap(10);
		peliruudukko.setVgap(10);
		peliruudukko.setPadding(new Insets(10, 30, 30, 30));
		peliruudukko.setPrefSize(300, 300);

		taytaPeliruudukko(peliruudukko, layout);

		layout.setCenter(peliruudukko);

		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
	}

	private void taytaPeliruudukko(GridPane peliruudukko, BorderPane layout) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				Button button = new Button(" ");
				setButton(button, peliruudukko, layout);
				peliruudukko.add(button, x, y);
			}
		}
	}

	private void setButton(Button button, GridPane peliruudukko, BorderPane layout) {
		button.setFont(Font.font("Monospaced", 40));
		button.setOnMouseClicked((event) -> {
			if (button.getText().equals(" ") || button.getText().isEmpty()) {
				button.setText(vuoro);

				if (vuoro.equals("X")) {
					vuoro = "Y";
				} else {
					vuoro = "X";
				}
			}
			if (onVoittaja(peliruudukko)) {
				Label label = new Label("Loppu!");
				label.setFont(Font.font("Monospaced", 40));
				label.setPadding(new Insets(0, 30, 0, 30));
				layout.setTop(label);

				lukitseRuudukko(peliruudukko);
			}
		});
	}

	private boolean onVoittaja(GridPane peliruudukko) {
		ObservableList<Node> nodes = peliruudukko.getChildren();

		// Only other text value in comparison gets trimmed, so that empty buttons won't equal
		return ((Button) nodes.get(0)).getText().trim().equals(((Button) nodes.get(1)).getText())
				&& ((Button) nodes.get(0)).getText().trim().equals(((Button) nodes.get(2)).getText())
				|| ((Button) nodes.get(3)).getText().trim().equals(((Button) nodes.get(4)).getText())
				&& ((Button) nodes.get(3)).getText().trim().equals(((Button) nodes.get(5)).getText())
				|| ((Button) nodes.get(6)).getText().trim().equals(((Button) nodes.get(7)).getText())
				&& ((Button) nodes.get(6)).getText().trim().equals(((Button) nodes.get(8)).getText())
				|| ((Button) nodes.get(0)).getText().trim().equals(((Button) nodes.get(4)).getText())
				&& ((Button) nodes.get(0)).getText().trim().equals(((Button) nodes.get(8)).getText())
				|| ((Button) nodes.get(2)).getText().trim().equals(((Button) nodes.get(4)).getText())
				&& ((Button) nodes.get(2)).getText().trim().equals(((Button) nodes.get(6)).getText());
	}

	private void lukitseRuudukko(GridPane peliruudukko) {
		for (Node node : peliruudukko.getChildren()) {
			Button button = (Button) node;
			button.setDisable(true);
		}
	}
}
