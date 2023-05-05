/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

//import Service.ServiceStock;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashBordController implements Initializable {
    @FXML
    private Label nb14;
    @FXML
    private Label nb13;
    @FXML
    private Label nb12;
    @FXML
    private Label nb11;
    @FXML
    private Label nb10;



    public DashBordController() {}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //ServiceStock serviceStock = new ServiceStock();
        try {

            //produit
            nb10.setText(serviceStock.getNumProducts().toString());

            //products in stock
            Integer productsInStock = serviceStock.getNumProductsInStock();
            if (productsInStock == null) nb11.setText("0");
            else nb11.setText(productsInStock.toString());

            //hors stock
            Integer countHorsStock = serviceStock.getNumHorsStock();
            nb12.setText(countHorsStock.toString());


            //stock expire
            nb13.setText(serviceStock.getNumExpiredStock().toString());


            //bientot expire
            nb14.setText(serviceStock.getNum6Mois().toString());

        } catch (Exception e) {}

    }

}
