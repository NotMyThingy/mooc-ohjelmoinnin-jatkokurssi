package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellus extends Application {

	@Override
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();

		/**
		 * Liukurit
		 */
		VBox controls = new VBox();

		BorderPane investmentsPane = new BorderPane();
		BorderPane interestsPane = new BorderPane();

		/**
		 * YLEMPI LIUKURI
		 */
		final Slider amoutSlider = new Slider(25, 250, 25);
		amoutSlider.setShowTickMarks(true);
		amoutSlider.setShowTickLabels(true);
		amoutSlider.setPadding(new Insets(10));

		Label depositLeftLabel = new Label("Kuukausittainen tallennus");
		Label depositRightLabel = new Label(String.valueOf(amoutSlider.getValue()));

		depositLeftLabel.setPadding(new Insets(10));
		depositRightLabel.setPadding(new Insets(10));

		/**
		 * ALEMPI LIUKURI
		 */
		final Slider interestSlider = new Slider(0, 10, 0);
		interestSlider.setShowTickMarks(true);
		interestSlider.setShowTickLabels(true);
		interestSlider.setPadding(new Insets(10));

		Label interestLeftLabel = new Label("Vuosittainen korko");
		Label interestRightLabel = new Label("0.0");

		interestLeftLabel.setPadding(new Insets(10));
		interestRightLabel.setPadding(new Insets(10));

		/**
		 * KOMPONENTIT BOXIIN
		 */
		investmentsPane.setLeft(depositLeftLabel);
		investmentsPane.setCenter(amoutSlider);
		investmentsPane.setRight(depositRightLabel);

		interestsPane.setLeft(interestLeftLabel);
		interestsPane.setCenter(interestSlider);
		interestsPane.setRight(interestRightLabel);

		controls.setPadding(new Insets(15));
		controls.getChildren().addAll(investmentsPane, interestsPane);

		/**
		 * VIIVAKAAVIO
		 */
		NumberAxis xAxis = new NumberAxis(0, 30, 1);
		NumberAxis yAxis = new NumberAxis();

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setAnimated(false);
		lineChart.setTitle("Säästölaskuri");

		/**
		 * LIUKUREIDEN TOIMINNALLISUUS
		 */
		XYChart.Series depositSeries = new XYChart.Series();
		amoutSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
			depositRightLabel.setText(String.valueOf(newValue.intValue()));

			lineChart.getData().remove(depositSeries);
			depositSeries.getData().clear();
			for (int year = 0; year <= 30; year++) {
				depositSeries.getData().add(year, new XYChart.Data(year, (newValue.intValue() * 12) * year));
			}
			lineChart.getData().add(depositSeries);
		});

		XYChart.Series interestSeries = new XYChart.Series();
		interestSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
			interestRightLabel.setText(String.format("%.2f", newValue.doubleValue()));

			lineChart.getData().remove(interestSeries);
			interestSeries.getData().clear();

			double paaoma = 0;
			int talletus = (int) amoutSlider.getValue();
			for (int year = 0; year <= 30; year++) {
				interestSeries.getData().add(new XYChart.Data(year, paaoma));
				System.out.println("Vuosi: " + year + " - Kertyma: " + paaoma);
				paaoma = (paaoma + (talletus * 12)) * (newValue.doubleValue() / 100 + 1);
			}
			lineChart.getData().add(interestSeries);
		});
		/**
		 * KOMPONENTIT ALUSTAAN
		 */

		layout.setTop(controls);
		layout.setCenter(lineChart);

		Scene scene = new Scene(layout, 640, 480);

		stage.setScene(scene);
		stage.show();
	}


	/*


	 */

	/**
	 * ALEMPI LIUKUVALITSIN KOROLLE
	 *//*
	private BorderPane createInterestSlider() {
		BorderPane bottomPane = new BorderPane();


		interestSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
			interestRight.setText(String.format("%.2f", interestSlider.getValue()));


		});

		return bottomPane;
	}
*/
	public static void main(String[] args) {
		Application.launch();
	}
}
