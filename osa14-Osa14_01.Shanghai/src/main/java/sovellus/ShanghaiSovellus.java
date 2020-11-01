package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

public class ShanghaiSovellus extends Application {

	@Override
	public void start(Stage stage) {
		Shanghai shanghai = new Shanghai();
		Map<Integer, Integer> arvot = shanghai.getValues();

		NumberAxis xAkseli = new NumberAxis(2006, 2018, 1);
		NumberAxis yAkseli = new NumberAxis(0, 100, 10);

		xAkseli.setLabel("Vuosi");
		yAkseli.setLabel("Sijoitus");

		LineChart<Number, Number> viivakaavio = new LineChart<>(xAkseli, yAkseli);
		viivakaavio.setTitle("Shanghai-ranking");

		XYChart.Series dataChart = new XYChart.Series();
		dataChart.setName("Helsingin Yliopisto");

		arvot.forEach((key, value) -> dataChart.getData().add(new XYChart.Data(key, value)));

		viivakaavio.getData().add(dataChart);

		Scene scene = new Scene(viivakaavio, 640, 480);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
