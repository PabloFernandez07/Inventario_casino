/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import CRUD.CrudItems;
import Pojos.Items;
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class PrincipalController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Button btn_inicio;
    @FXML
    private Button btn_inventario;
    @FXML
    private Button btn_añadir;
    @FXML
    private Button btn_objetivos;
    @FXML
    private Button btn_fichas;
    @FXML
    private Pane header;
    @FXML
    private Label botonCerrar;
    @FXML
    private Label botonMinimizar;

    private double y = 0;
    private double x = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void loadPage(String page) {
        try {
            Parent root = null;

            root = FXMLLoader.load(getClass().getResource("/Vistas/" + page + ".fxml"));

            bp.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void abrirInicio(ActionEvent event) {
        loadPage("panel_inicio");
    }

    @FXML
    private void abrirInventario(ActionEvent event) {
        List<Items> listaItems = null;
        try {
            listaItems = CrudItems.getListItems();
        } catch (NullPointerException ex) {
            System.out.println("Error." + ex.getLocalizedMessage());
        }
        Panel_inventarioController.numItems = listaItems.size();

        System.out.println(listaItems.size());
        loadPage("panel_inventario");

    }

    @FXML
    private void abrirAnadir(ActionEvent event) {
        loadPage("panel_anadir");
    }

    @FXML
    private void abrirObjetivos(ActionEvent event) {
        loadPage("panel_objetivos");
    }

    @FXML
    private void abrirFichas(ActionEvent event) {
        loadPage("panel_fichas");
    }

    @FXML
    private void cerrar(MouseEvent event) {
        Stage stage = (Stage) botonCerrar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void minimizar(MouseEvent event) {
        Stage stage = (Stage) botonMinimizar.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void onClicHeaderPressed(MouseEvent event) {
        //Poder mover la ventana con el mouse
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void onClicHeaderDragged(MouseEvent event) {
        //Poder mover la ventana con el mouse
        Stage stage = (Stage) header.getScene().getWindow();
        stage.setY(event.getScreenY() - y);
        stage.setX(event.getScreenX() - x);
    }

}
