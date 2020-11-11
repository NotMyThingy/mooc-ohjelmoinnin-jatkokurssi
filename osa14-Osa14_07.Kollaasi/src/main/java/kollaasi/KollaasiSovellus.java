package kollaasi;

import javafx.application.Application;

import static javafx.application.Application.launch;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KollaasiSovellus extends Application {

	@Override
	public void start(Stage stage) {

		// esimerkki avaa kuvan, luo uuden kuvan, ja kopioi avatun kuvan
		// uuteen kuvaan pikseli kerrallaan
		Image lahdeKuva = new Image("file:monalisa.png");

		PixelReader kuvanLukija = lahdeKuva.getPixelReader();

		int leveys = (int) lahdeKuva.getWidth();
		int korkeus = (int) lahdeKuva.getHeight();

		WritableImage kohdeKuva = new WritableImage(leveys, korkeus);
		PixelWriter kuvanKirjoittaja = kohdeKuva.getPixelWriter();

		// KIRJOITETAAN KAIKKI NELJA KULMAA
		for (int x = 0; x < leveys / 2; x++) {
			for (int y = 0; y < korkeus / 2; y++) {
				Color color = kuvanLukija.getColor(x * 2, y * 2);

				kuvanKirjoittaja.setColor(x, y, color);
				kuvanKirjoittaja.setColor(x + leveys / 2, y, color);
				kuvanKirjoittaja.setColor(x, y + korkeus / 2, color);
				kuvanKirjoittaja.setColor(x + leveys / 2, y + korkeus / 2, color);
			}
		}

		// WARHOL
		kuvanLukija = kohdeKuva.getPixelReader();
		for (int x = 0; x < leveys; x++) {
			for (int y = 0; y < korkeus; y++) {
				Color color = kuvanLukija.getColor(x, y);

				double red = 1 - color.getRed();
				double green = 1 - color.getGreen();
				double blue = 1 - color.getBlue();

				kuvanKirjoittaja.setColor(x, y, new Color(red, green, blue, color.getOpacity()));
			}
		}

		ImageView kuva = new ImageView(kohdeKuva);

		Pane pane = new Pane();
		pane.getChildren().add(kuva);

		stage.setScene(new Scene(pane));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
