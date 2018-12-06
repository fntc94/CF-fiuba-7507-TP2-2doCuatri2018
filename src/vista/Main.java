package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vista.controles.InicioControl;
import vista.controles.JuegoControl;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {

        InicioControl inicioControl = new InicioControl(primaryStage);
        primaryStage.setTitle("Age ofEmpires II");
        primaryStage.setScene(new Scene(inicioControl));
        primaryStage.show();
    }

}
