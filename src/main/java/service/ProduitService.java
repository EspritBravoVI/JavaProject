package service;

import entite.Produit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.DataSource;

public class ProduitService {
  Connection conn = DataSource.getInstance().getCnx();

  public void addProduit(String libelle, int quantite,String categorie) throws SQLException {

    PreparedStatement add = conn.prepareStatement("INSERT INTO produit VALUES(NULL,?,?,?)");

    add.setString(1, libelle);
    add.setInt(2, quantite);
    add.setString(3, categorie);

    add.executeUpdate();
    add.close();
  }
  public void updateProduit(int newQte, String libelle, String newLibelle) throws SQLException{
    PreparedStatement add = conn.prepareStatement("UPDATE produit SET quan=? WHERE libelle LIKE ?");
    add.setInt(1, newQte);
    add.setString(2, libelle);
    add.executeUpdate();

    add.close();
  }
  public ArrayList<Produit> getProducts() throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from produit");
    ResultSet rs= ps.executeQuery();
    ArrayList<Produit> stocks = new ArrayList<>();

    while (rs.next()) {
      Produit produit = new Produit(rs.getString("libelle"), "categorie", 0);
      stocks.add(produit);
    }
    rs.close();
    ps.close();

    return stocks;
  }
  public static void main(String[] args) throws SQLException {
    ProduitService produitService = new ProduitService();
    System.out.println(produitService.getProducts().get(0));
  }


}
