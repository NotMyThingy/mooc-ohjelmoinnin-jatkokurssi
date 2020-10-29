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
	public void start(Stage stage) throws Exception {

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

		taytaPeliruudukko(peliruudukko);

		layout.setCenter(peliruudukko);

		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
	}

	private void taytaPeliruudukko(GridPane peliruudukko) {
		Button button1 = new Button(" ");
		setButton(button1);
		Button button2 = new Button(" ");
		setButton(button2);
		Button button3 = new Button(" ");
		setButton(button3);
		Button button4 = new Button(" ");
		setButton(button4);
		Button button5 = new Button(" ");
		setButton(button5);
		Button button6 = new Button(" ");
		setButton(button6);
		Button button7 = new Button(" ");
		setButton(button7);
		Button button8 = new Button(" ");
		setButton(button8);
		Button button9 = new Button(" ");
		setButton(button9);

		peliruudukko.add(button1, 0, 0);
		peliruudukko.add(button2, 1, 0);
		peliruudukko.add(button3, 2, 0);
		peliruudukko.add(button4, 0, 1);
		peliruudukko.add(button5, 1, 1);
		peliruudukko.add(button6, 2, 1);
		peliruudukko.add(button7, 0, 2);
		peliruudukko.add(button8, 1, 2);
		peliruudukko.add(button9, 2, 2);
	}

	private void setButton(Button button) {
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
		});
	}

	private boolean OnkoVoittaja(GridPane peliruudukko) {
		ObservableList<Node> nodes = peliruudukko.getChildren();
		System.out.println("perkl - " + nodes.get(0).getAccessibleText());
		if (nodes.get(0).equals(nodes.get(1)) && nodes.get(0).equals(nodes.get(2))
				|| nodes.get(3).equals(nodes.get(4)) && nodes.get(3).equals(nodes.get(5))
				|| nodes.get(6).equals(nodes.get(7)) && nodes.get(6).equals(nodes.get(8))) {
			return true;
		}

		return false;
	}

	private void lukitseRuudukko(GridPane peliruudukko) {
	}
}
