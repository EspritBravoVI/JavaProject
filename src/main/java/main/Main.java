package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;


public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {

    //FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/MenuLoader.fxml"));
    //URL url = getClass().getClassLoader().getResource("../GUI/MenuLoader.fxml");

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("E:/Esprit/Java/JavaProject/src/main/java/GUI/MenuLoader.fxml"));
    fxmlLoader.setRoot(new AnchorPane());
    Parent root = fxmlLoader.load();
    Scene scene = new Scene(root);
    scene.setRoot(root);
    stage.setScene(scene);
    stage.show();
  }
}