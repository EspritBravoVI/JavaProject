package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataSource {
  //DB PARAM
  static final String URL ="jdbc:mysql://localhost:3306/app";
  static final String USER ="root";
  static final String PASSWORD ="";
  //var
  private Connection connection;

  static DataSource instance;

  private DataSource(){
    try {
      connection=DriverManager.getConnection(URL, USER,PASSWORD);
      System.out.println("connexion etablie");
    } catch (SQLException ex) {
      Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Connection getCnx() {
    return connection;
  }

  public static DataSource getInstance() {
    if(instance == null)
      instance = new DataSource();

    return instance;
  }
  public static void main(String[] args) {

    Connection connection1=DataSource.getInstance().getCnx();

  }

}
