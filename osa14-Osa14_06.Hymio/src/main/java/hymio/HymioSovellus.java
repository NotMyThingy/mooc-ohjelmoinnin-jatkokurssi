package hymio;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HymioSovellus extends Application {


	@Override
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();

		Canvas canvas = new Canvas(640, 480);
		GraphicsContext context = canvas.getGraphicsContext2D();

		// BACKGROUND
		context.setFill(Color.WHITE);
		context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// DRAWING
		context.setFill(Color.BLACK);
		context.fillRect(180, 70, 70, 70);
		context.fillRect(390, 70, 70, 70);

		context.fillRect(110, 240, 70, 70);
		context.fillRect(460, 240, 70, 70);

		context.fillRect(180, 310, 70, 70);
		context.fillRect(250, 310, 70, 70);
		context.fillRect(320, 310, 70, 70);
		context.fillRect(390, 310, 70, 70);

		layout.setCenter(canvas);
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Application.launch();
	}
}
