/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import CRUD.CrudItems;
import Pojos.Items;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class Panel_inventarioController implements Initializable {

    @FXML
    private GridPane gridPane;
    
    public static int numItems = 0;
    
    private void mostrarTamaño() {
        List<Items> listaItems = CrudItems.getListItems();

        JOptionPane.showMessageDialog(null, listaItems.size());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}
