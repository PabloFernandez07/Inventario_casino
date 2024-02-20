/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Inventario;

import Conexion.Conexion;
import java.awt.Image;
import java.time.LocalDate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.persistence.EntityManager;

/**
 *
 * @author pablo
 */
public class Main extends Application {

    public static void main(String[] args) {        
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Vistas/Principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Inventario");
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.getIcons().add(new Image("/com/lostingameplay/imagenes/LogotipoBoton.png"));
        stage.setScene(scene);
        
        stage.show();
    }
}
