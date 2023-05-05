/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import entite.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import service.ProduitService;
import service.UserService;
import utils.ModelTableProduct;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class PointDeVenteController  {
     boolean status = false;
   
    private final ObservableList<String> catinfo = FXCollections.observableArrayList("médicament");
    private final ObservableList<ModelTableProduct> oblist = FXCollections.observableArrayList();
    @FXML
    private Button connect;
    @FXML
    private PasswordField passzone;
    @FXML
    private TextField idzone;
    @FXML
    private AnchorPane superanch;
    @FXML
    private AnchorPane anchcnx;
    @FXML
    private AnchorPane anchset;
    @FXML
    private Label note;
    @FXML
    private Button btndelete;
    @FXML
    private Label deleteerror;
    @FXML
    private Label adderror;
    @FXML
    private Button btnadd;
    @FXML
    private ComboBox<String> catcombo;
    @FXML
    private TextField idcat;
    @FXML
    private TextField designation;
    @FXML
    private TextField quantity;
    @FXML
    private TableColumn<ModelTableProduct, String> des;
    @FXML
    private TableView<ModelTableProduct> tab;
    @FXML
    private TableColumn<ModelTableProduct, String> cat;
    @FXML
    private TextField iddes;
    ProduitService produitService = new ProduitService();
    UserService userService = new UserService();
    @FXML
    private Label id;
    @FXML
    private Label pw;
    @FXML
    private TableColumn<?, ?> Qte;

    @FXML
    void tabclick(MouseEvent event) {
        if (tab.getSelectionModel().getSelectedItem() != null) {
            iddes.setText(tab.getSelectionModel().getSelectedItem().getDes());
            idcat.setText(tab.getSelectionModel().getSelectedItem().getCatg());
            btndelete.setDisable(false);
        }
    }

    @FXML
    void add(MouseEvent event) {

        boolean test = true;
        //verifier s'il ya des champs vides
        if ((designation.getText().isEmpty()) || (catcombo.getSelectionModel().getSelectedIndex() == -1)) {
            adderror.setText("Données manquantes !");
          // Mee  MenuLoaderController.player("src/Ressources/media/error.mp3");
            test = false;
        }
        if (test == true) {
            try {

                // inserer les donnees saisies dans la table usertbl en utilisant l'interface PreparedStatement
                produitService.addProduit(designation.getText(),Integer.parseInt(quantity.getText()), catcombo.getSelectionModel().getSelectedItem());

                //afficher tous les elements de la base  + vider les champs + afficher un message
                adderror.setText("Product Added ");

                catcombo.getSelectionModel().clearSelection();
                designation.setText("");
                quantity.setText("");
                deleteerror.setText("");


            } catch (Exception e) {
                adderror.setText("2 Products cant have the same ID");

            }

        }
        refresh();


    }

    @FXML
    void delete(MouseEvent event) {
        boolean allow = true;


        if (allow == true) {
            Stage stage = (Stage) superanch.getScene().getWindow();
            Alert.AlertType type = Alert.AlertType.CONFIRMATION;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);
            alert.getDialogPane().setHeaderText("This Action is irreversable !!!");
            alert.getDialogPane().setContentText("Would you like to continue with this action ?");
            Optional<ButtonType> result = alert.showAndWait();
            boolean test = false;
            if (result.get() == ButtonType.OK) {
                if (test == false)
                    try {
                        // delete product

                        produitService.deleteProduit(iddes.getText(), idcat.getText());

                        deleteerror.setText("Product deleted ! ");
                        refresh();
                        iddes.setText("");
                        idcat.setText("");
                        adderror.setText("");

                        btndelete.setDisable(true);

                    } catch (Exception e) {
                        deleteerror.setText("Error !");
                        refresh();
                        adderror.setText("");
                    }
            } else if (result.get() == ButtonType.CANCEL) {

                refresh();
                deleteerror.setText("Action Canceled!");
                adderror.setText("");

            }
        }
        refresh();


    }


   public void connect() {
        try {
            boolean userExists = userService.userLogin(idzone.getText(), passzone.getPromptText(), passzone.getText());
            if ((userExists && ((idzone.getText().equals("admin")) || (idzone.getText().equals("dev"))))) {
                anchcnx.setVisible(false);
                anchset.setVisible(true);

            } else {
                //Password incorrect message
                note.setText("Username or Password is incorrect !");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void EnterKeyConnect(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            connect();
        }
    }

    @FXML
    void Seconnecter(MouseEvent event) {
        connect();
    }

    private void refresh() {//refresh tab
        try {
            tab.getItems().clear();
            ArrayList<Produit> allProducts = produitService.getProducts();
            for (Produit product: allProducts) {
                ModelTableProduct tableList = new ModelTableProduct(product.getLibelle(), product.getCategorie(),product.getQuantite());
                oblist.add(tableList);

            }
        } catch (SQLException ex) {}
    }
}
