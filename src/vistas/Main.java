package vistas;

import controladores.InicioController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;



public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader inicioLoader = new FXMLLoader(getClass().getResource("InicioView.fxml"));
        Parent inicioView = inicioLoader.load();

        InicioController inicioController = inicioLoader.getController();
        inicioController.setStage(stage);

        stage.setTitle("Age ofEmpires II");
        stage.setScene(new Scene(inicioView));
        stage.show();
    }

}
