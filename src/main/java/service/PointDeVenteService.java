package service;

import entite.PointDeVente;
import entite.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DataSource;

public class PointDeVenteService {
  Connection conn = DataSource.getInstance().getCnx();

  public void addProduit(String localisation) throws SQLException {


    PreparedStatement add = conn.prepareStatement("INSERT INTO point_de_vente VALUES(NULL,?)");

    add.setString(1, localisation);

    add.executeUpdate();
    add.close();
  }
  public void updateProduit(String newLocalisation,int id) throws SQLException{
    PreparedStatement add = conn.prepareStatement("UPDATE point_de_vente SET localisation=?WHERE id=?");
    add.setString(1, newLocalisation);
    add.setInt(2, id);
    add.executeUpdate();

    add.close();
  }
  public ArrayList<PointDeVente> getAllPointDeVente() throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from point_de_vente");
    ResultSet rs= ps.executeQuery();
    ArrayList<PointDeVente> pointDeVenteList = new ArrayList<>();

    while (rs.next()) {
      PointDeVente pointDeVente = new PointDeVente(rs.getInt("id"),rs.getString("localisation"));
      pointDeVenteList.add(pointDeVente);
    }
    rs.close();
    ps.close();

    return pointDeVenteList;
  }
  public static void main(String[] args) throws SQLException {
    PointDeVenteService pointDeVenteService = new PointDeVenteService();
    pointDeVenteService.addProduit("Ariana");
    pointDeVenteService.addProduit("Tunis");
    System.out.println(pointDeVenteService.getAllPointDeVente());
  }
}
