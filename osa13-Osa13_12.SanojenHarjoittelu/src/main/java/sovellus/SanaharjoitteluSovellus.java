package sovellus;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class SanaharjoitteluSovellus extends Application {

	private Sanakirja sanakirja;

	@Override
	public void init() {
		this.sanakirja = new Sanakirja();
	}

	@Override
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();

		LisaysNakyma lisaysnakyma = new LisaysNakyma(sanakirja);
		HarjoitteluNakyma harjoitusnakyma = new HarjoitteluNakyma(sanakirja);

		HBox menu = new HBox();
		menu.setPadding(new Insets(20));
		menu.setSpacing(10);

		Button lisaysnappi = new Button("Lisää sanoja");
		lisaysnappi.setOnMouseClicked((event) -> layout.setCenter(lisaysnakyma.getView()));

		Button harjoitusnappi = new Button("Harjoittele");
		harjoitusnappi.setOnMouseClicked((event) -> layout.setCenter(harjoitusnakyma.getView()));

		menu.getChildren().addAll(lisaysnappi, harjoitusnappi);

		layout.setTop(menu);
		layout.setCenter(lisaysnakyma.getView());

		Scene scene = new Scene(layout, 400, 300);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(SanaharjoitteluSovellus.class);
	}

}
