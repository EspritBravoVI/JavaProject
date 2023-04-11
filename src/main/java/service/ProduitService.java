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

    //oral care, skin care, sun care, hair care, decorative cosmetics, body care and perfumes

    //list deroulante front-end to choose from those 7 categories

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

  public ArrayList<Produit> getProductsPerCategory(String cat) throws SQLException {


    PreparedStatement ps = conn.prepareStatement("select * from produit where categorie=?");
    ps.setString(1,cat);
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

  public ArrayList<Produit> getProductsEnRuptureDeStock() throws SQLException {


    PreparedStatement ps = conn.prepareStatement("select * from produit where quantite = 0");
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

  public ArrayList<Produit> getProductsDisponible() throws SQLException {


    PreparedStatement ps = conn.prepareStatement("select * from produit where quantite > 0");
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
    produitService.addProduit("body screen 50",Integer.valueOf(2),"hair care");
    System.out.println(produitService.getProductsPerCategory("hair care"));
    System.out.println(produitService.getProductsEnRuptureDeStock());
    //produitService.updateProduit(2,1,"loubya","bnina");
  }


}
