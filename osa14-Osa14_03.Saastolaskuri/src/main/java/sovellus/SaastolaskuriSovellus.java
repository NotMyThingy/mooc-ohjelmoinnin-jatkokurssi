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

	private LineChart lineChart;
	private int monthlyInvestment;

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


	private VBox createControls() {
		final VBox controls = new VBox();
		controls.setPadding(new Insets(15));

		final BorderPane topPane = createInvestmentSlider();
		final BorderPane bottomPane = createInterestSlider();

		controls.getChildren().addAll(topPane, bottomPane);

		return controls;
	}


	private BorderPane createInvestmentSlider() {
		final BorderPane investmentPane = new BorderPane();

		final Slider investment = new Slider(25, 250, 25);
		investment.setShowTickMarks(true);
		investment.setShowTickLabels(true);
		investment.setPadding(new Insets(10));

		final Label depositLeftLabel = new Label("Kuukausittainen tallennus");
		final Label depositRightLabel = new Label(String.valueOf(investment.getValue()));

		depositLeftLabel.setPadding(new Insets(10));
		depositRightLabel.setPadding(new Insets(10));

		investmentPane.setLeft(depositLeftLabel);
		investmentPane.setCenter(investment);
		investmentPane.setRight(depositRightLabel);

		final XYChart.Series depositSeries = new XYChart.Series();
		investment.valueProperty().addListener((observableValue, oldValue, newValue) -> {
			monthlyInvestment = newValue.intValue();
			depositRightLabel.setText(String.valueOf(newValue.intValue()));

			lineChart.getData().remove(depositSeries);
			depositSeries.getData().clear();
			for (int year = 0; year <= 30; year++) {
				depositSeries.getData().add(year, new XYChart.Data(year, (monthlyInvestment * 12) * year));
			}
			lineChart.getData().add(depositSeries);
		});

		return investmentPane;
	}


	private BorderPane createInterestSlider() {
		final BorderPane interestPane = new BorderPane();

		final Slider interest = new Slider(0, 10, 0);
		interest.setShowTickMarks(true);
		interest.setShowTickLabels(true);
		interest.setPadding(new Insets(10));

		final Label interestLeftLabel = new Label("Vuosittainen korko");
		final Label interestRightLabel = new Label("0.0");

		interestLeftLabel.setPadding(new Insets(10));
		interestRightLabel.setPadding(new Insets(10));

		interestPane.setLeft(interestLeftLabel);
		interestPane.setCenter(interest);
		interestPane.setRight(interestRightLabel);

		final XYChart.Series interestSeries = new XYChart.Series();
		interest.valueProperty().addListener((observableValue, oldValue, newValue) -> {
			interestRightLabel.setText(String.format("%.2f", newValue.doubleValue()));

			lineChart.getData().remove(interestSeries);
			interestSeries.getData().clear();

			double savings = 0.0;
			for (int year = 0; year <= 30; year++) {
				interestSeries.getData().add(new XYChart.Data(year, savings));
				savings = (savings + (monthlyInvestment * 12)) * (newValue.doubleValue() / 100 + 1);
			}
			interestSeries.getData().stream().forEach(i -> System.out.println(i));

			lineChart.getData().add(interestSeries);
		});

		return interestPane;
	}

	private LineChart<Number, Number> creteNewChart() {
		NumberAxis xAxis = new NumberAxis(0, 30, 1);
		NumberAxis yAxis = new NumberAxis();

		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setAnimated(false);
		lineChart.setTitle("Säästölaskuri");

		return lineChart;
	}


	public static void main(String[] args) {
		Application.launch();
	}
}
