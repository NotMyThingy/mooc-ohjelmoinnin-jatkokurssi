package sovellus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.Map;

public class PuolueetSovellus extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		PuolueData puolueData = new PuolueData();

		NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
		NumberAxis yAxis = new NumberAxis(0, 30, 5);

		xAxis.setLabel("Vuosi");
		yAxis.setLabel("Suhteellinen kannatus (%)");

		xAxis.setTickLabelFormatter(new StringConverter<Number>() {
			@Override
			public String toString(Number number) {
				return String.valueOf(number.intValue());
			}

			@Override
			public Number fromString(String s) {
				return null;
			}
		});

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Suhteellinen kannatus vuosina 1968 - 2008");

		Map<String, Map<Integer, Double>> values = puolueData.getData();

		values.keySet().stream().forEach(party -> {
			XYChart.Series data = new XYChart.Series();
			data.setName(party);

			values.get(party).entrySet().stream().forEach(pair -> {
				data.getData().add(new XYChart.Data<>(pair.getKey(), pair.getValue()));
			});

			lineChart.getData().add(data);
		});

		Scene scene = new Scene(lineChart, 640, 480);

		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch();
	}
}
