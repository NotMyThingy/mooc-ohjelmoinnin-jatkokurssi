package otsikko;


import javafx.application.Application;
import javafx.stage.Stage;

public class KayttajanOtsikko extends Application {


    @Override
    public void start(Stage stage) {
        try {
            Parameters params = getParameters();
            String otsikko = params.getNamed().get("otsikko");
            stage.setTitle(otsikko);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stage.show();
    }
}
