package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LisaysNakyma {

	private final Sanakirja sanakirja;

	public LisaysNakyma(Sanakirja sanakirja) {
		this.sanakirja = sanakirja;
	}

	public Parent getView() {
		GridPane layout = new GridPane();

		Label sanaohje = new Label("Sana");
		TextField sanakentta = new TextField();
		Label kaannosohje = new Label("Käännös");
		TextField kaannoskentta = new TextField();

		layout.setAlignment(Pos.CENTER);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPadding(new Insets(10));

		Button lisaysnappi = new Button("Lisää sanapari");

		lisaysnappi.setOnMouseClicked((event) -> {
			String sana = sanakentta.getText();
			String kaannos = kaannoskentta.getText();

			sanakirja.lisaa(sana, kaannos);
			sanakentta.clear();
			kaannoskentta.clear();
		});

		layout.add(sanaohje, 0, 0);
		layout.add(sanakentta, 0, 1);
		layout.add(kaannosohje, 0, 2);
		layout.add(kaannoskentta, 0, 3);
		layout.add(lisaysnappi, 0, 4);

		return layout;
	}
}
