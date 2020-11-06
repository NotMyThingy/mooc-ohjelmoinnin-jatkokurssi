package sovellus;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
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

	private LineChart<Number, Number> lineChart;
	private Slider depositSlider;

	@Override
	public void start(Stage stage) {
		BorderPane layout = new BorderPane();

		NumberAxis xAxis = new NumberAxis(0, 30, 1);
		NumberAxis yAxis = new NumberAxis();

		lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setAnimated(false);
		lineChart.setLegendVisible(false);
		lineChart.setTitle("Säästölaskuri");

		VBox controls = createControls();

		layout.setTop(controls);
		layout.setCenter(lineChart);

		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
	}


	private VBox createControls() {
		final VBox controls = new VBox();
		controls.setPadding(new Insets(15));

		final BorderPane topPane = createDepositSlider();
		final BorderPane bottomPane = createInterestSlider();

		controls.getChildren().addAll(topPane, bottomPane);

		return controls;
	}


	private BorderPane createDepositSlider() {
		final BorderPane depositPane = new BorderPane();

		depositSlider = new Slider(25, 250, 25);
		depositSlider.setShowTickMarks(true);
		depositSlider.setShowTickLabels(true);
		depositSlider.setPadding(new Insets(10));

		final Label depositLeftLabel = new Label("Kuukausittainen tallennus");
		final Label depositRightLabel = new Label();
		depositRightLabel.textProperty().bind(Bindings
				.format("%.0f", depositSlider.valueProperty()));

		setStyling(depositPane, depositSlider, depositLeftLabel, depositRightLabel);

		final XYChart.Series<Number, Number> depositSeries = new XYChart.Series<>();
		depositSeries.setName("Monthly deposit");

		this.lineChart.getData().add(depositSeries);

		/*
		 * SLIDER EVENT LISTENER
		 */
		depositSlider.setOnMouseReleased((event) -> {
			depositSeries.getData().clear();
			for (int year = 0; year <= 30; year++) {
				depositSeries
						.getData()
						.add(new XYChart.Data<>(year, (depositSlider.valueProperty().intValue() * 12) * year));
			}
		});

		return depositPane;
	}


	private BorderPane createInterestSlider() {
		final BorderPane interestPane = new BorderPane();

		final Slider interestSlider = new Slider(0, 10, 0);
		interestSlider.setShowTickMarks(true);
		interestSlider.setShowTickLabels(true);
		interestSlider.setPadding(new Insets(10));

		final Label interestLeftLabel = new Label("Vuosittainen korko");
		final Label interestRightLabel = new Label();
		interestRightLabel.textProperty().bind(Bindings
				.format("%.2f", interestSlider.valueProperty()));

		setStyling(interestPane, interestSlider, interestLeftLabel, interestRightLabel);

		final XYChart.Series<Number, Number> interestSeries = new XYChart.Series<>();
		interestSeries.setName("Annual interest");

		this.lineChart.getData().add(interestSeries);

		/*
		 * SLIDER EVENT LISTENER
		 */
		interestSlider.setOnMouseReleased((event) -> {
			interestSeries.getData().clear();

			double annualInterest = interestSlider.valueProperty().doubleValue() / 100 + 1;
			double annualDeposit = depositSlider.valueProperty().intValue() * 12;
			double savings = 0.0;

			for (int year = 0; year <= 30; year++) {
				interestSeries
						.getData()
						.add(new XYChart.Data<>(year, savings));

				savings = (savings + annualDeposit) * annualInterest;
			}
		});

		return interestPane;
	}


	private void setStyling(BorderPane pane, Slider slider, Label labelL, Label labelR) {
		labelL.setPadding(new Insets(10));
		labelR.setPadding(new Insets(10));

		pane.setLeft(labelL);
		pane.setCenter(slider);
		pane.setRight(labelR);
	}


	public static void main(String[] args) {
		launch(SaastolaskuriSovellus.class);
	}
}
