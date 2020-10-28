package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class HarjoitteluNakyma {

	private final Sanakirja sanakirja;

	private String sana;

	public HarjoitteluNakyma(Sanakirja sanakirja) {
		this.sanakirja = sanakirja;
		this.sana = sanakirja.arvoUusiSana();
	}

	public Parent getView() {
		GridPane layout = new GridPane();

		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10));

		Label sanaohje = new Label("Käännä sana '" + this.sana + "'");
		Label palaute = new Label("");

		TextField kaannoskentta = new TextField();

		Button tarkistusnappi = new Button("Tarkista");
		tarkistusnappi.setOnMouseClicked((event) -> {
			String kaannos = kaannoskentta.getText();
			if (sanakirja.hae(sana).equals(kaannos)) {
				palaute.setText("Oikein!");
			} else {
				palaute.setText("Väärin! Sanan '"
						+ sana
						+ "' käännös on '"
						+ sanakirja.hae(sana)
						+ "'.");
				return;
			}

			this.sana = this.sanakirja.arvoUusiSana();
			sanaohje.setText("Käännä sana '" + this.sana + "'");
			kaannoskentta.clear();
		});

		layout.add(sanaohje, 0, 0);
		layout.add(kaannoskentta, 0, 1);
		layout.add(tarkistusnappi, 0, 2);
		layout.add(palaute, 0, 3);

		return layout;
	}

}
