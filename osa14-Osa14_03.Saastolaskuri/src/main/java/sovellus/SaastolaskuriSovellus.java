package sovellus;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

	private LineChart lineChart;

	@Override
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();

		VBox controls = createControls();
		layout.setTop(controls);

		lineChart = creteNewChart();
		layout.setCenter(lineChart);

		Scene scene = new Scene(layout, 640, 480);

		stage.setScene(scene);
		stage.show();
	}

	/**
	 * LUODAAN KONTROLLIT
	 */
	private VBox createControls() {
		VBox controls = new VBox();
		controls.setPadding(new Insets(15));

		BorderPane topPane = createDepositSlider();
		BorderPane bottomPane = createInterestSlider();

		controls.getChildren().addAll(topPane, bottomPane);

		return controls;
	}

	/**
	 * YLEMPI LIUKUVALITSIN TALLETUKSELLE
	 */
	private BorderPane createDepositSlider() {
		BorderPane topPane = new BorderPane();

		Slider amoutSlider = new Slider(25, 250, 25);
		amoutSlider.setShowTickMarks(true);
		amoutSlider.setShowTickLabels(true);
		amoutSlider.setPadding(new Insets(10));

		Label depositLeft = new Label("Kuukausittainen tallennus");
		Label depositRight = new Label(String.valueOf(amoutSlider.getValue()));

		depositLeft.setPadding(new Insets(10));
		depositRight.setPadding(new Insets(10));

		topPane.setLeft(depositLeft);
		topPane.setCenter(amoutSlider);
		topPane.setRight(depositRight);

		amoutSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldie, Number newbie) {
				depositRight.setText(String.format("%.1f", newbie.doubleValue()));

				XYChart.Series data = new XYChart.Series();
				for (int i = 0; i < 30; i++) {
					data.getData().add(newbie.intValue() * 12);
				}

				lineChart.getData().add(data);

			}
		});

		return topPane;
	}

	/**
	 * ALEMPI LIUKUVALITSIN KOROLLE
	 */
	private BorderPane createInterestSlider() {
		BorderPane bottomPane = new BorderPane();

		Slider interestSlider = new Slider(0, 10, 0);
		interestSlider.setShowTickMarks(true);
		interestSlider.setShowTickLabels(true);
		interestSlider.setPadding(new Insets(10));

		Label interestLeft = new Label("Vuosittainen korko");
		Label interestRight = new Label("0.0");

		interestLeft.setPadding(new Insets(10));
		interestRight.setPadding(new Insets(10));

		bottomPane.setLeft(interestLeft);
		bottomPane.setCenter(interestSlider);
		bottomPane.setRight(interestRight);

		interestSlider.valueProperty().addListener((event) -> interestRight.setText(String.format("%.2f", interestSlider.getValue())));
		return bottomPane;
	}

	/**
	 * LUODAAN KAAVIO
	 */
	private LineChart creteNewChart() {
		NumberAxis xAxis = new NumberAxis(0, 30, 1);
		NumberAxis yAxis = new NumberAxis();

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Säästölaskuri");

		return lineChart;
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
