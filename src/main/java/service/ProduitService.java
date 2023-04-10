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
  public void updateProduit(int newQte, Integer id, String newLibelle,String newCat) throws SQLException{
    PreparedStatement add = conn.prepareStatement("UPDATE produit SET quantite=?,libelle=?,categorie=? WHERE id=?");
    add.setInt(1, newQte);
    add.setString(2, newLibelle);
    add.setString(3, newCat);
    add.setInt(4, id);
    add.executeUpdate();

    add.close();
  }
  public ArrayList<Produit> getProducts() throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from produit");
    ResultSet rs= ps.executeQuery();
    ArrayList<Produit> stocks = new ArrayList<>();

    while (rs.next()) {
      Produit produit = new Produit(rs.getString("libelle"),rs.getString("categorie"),rs.getInt("quantite"));
      stocks.add(produit);
    }
    rs.close();
    ps.close();

    return stocks;
  }
  public static void main(String[] args) throws SQLException {
    ProduitService produitService = new ProduitService();
    System.out.println(produitService.getProducts().get(0).getCategorie());
    //produitService.addProduit("sun screen 50",Integer.valueOf(77),"visage");
    //produitService.updateProduit(2,1,"loubya","bnina");
  }


}
