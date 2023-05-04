package service;

import entite.Fournisseur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.DataSource;

public class FournisseurService {
  Connection conn = DataSource.getInstance().getCnx();

  public void addFournisseur(String nom, String categorieProduit, String contact) throws SQLException {


    PreparedStatement add = conn.prepareStatement("INSERT INTO fournisseur VALUES(NULL,?,?,?)");

    add.setString(1, nom);
    add.setString(2, categorieProduit);
    add.setString(3, contact);

    add.executeUpdate();
    add.close();
  }
  public void updateFournisseur(int id, String categorieProduit, String contact) throws SQLException{
    PreparedStatement add = conn.prepareStatement("UPDATE fournisseur SET categorie_produit=? , contact=? WHERE id=?");
    add.setString(1, categorieProduit);
    add.setString(2, contact);
    add.setInt(3, id);
    add.executeUpdate();

    add.close();
  }


  public void deleteFournisseur(int id) throws SQLException{
    PreparedStatement add = conn.prepareStatement("DELETE FROM fournisseur WHERE id=?");

    add.setInt(1, id);
    add.executeUpdate();
    add.close();
  }

  public ArrayList<Fournisseur> getAllFournisseur() throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from fournisseur");
    ResultSet rs= ps.executeQuery();
    ArrayList<Fournisseur> fournisseurList = new ArrayList<>();

    while (rs.next()) {
      Fournisseur fournisseur = new Fournisseur(rs.getString("nom"),rs.getString("prenom"),rs.getInt("num"),rs.getString("categorie_produit"));
      fournisseurList.add(fournisseur);
    }
    rs.close();
    ps.close();

    return fournisseurList;
  }

  public List<Fournisseur> getFournisseurPerCategory(String cat) throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from fournisseur");
    ResultSet rs= ps.executeQuery();
    ArrayList<Fournisseur> fournisseurList = new ArrayList<>();

    while (rs.next()) {
      Fournisseur fournisseur = new Fournisseur(rs.getString("nom"),rs.getString("prenom"),rs.getInt("num"),rs.getString("categorie_produit"));
      fournisseurList.add(fournisseur);
    }
    rs.close();
    ps.close();

    List<Fournisseur> filtred;
    filtred = fournisseurList.stream().filter(f -> f.getCategorie().equals(cat)).collect(Collectors.toList());

    return filtred;
  }

  public List<Fournisseur> getFournisseurSorted() throws SQLException {

    PreparedStatement ps = conn.prepareStatement("select * from fournisseur");
    ResultSet rs= ps.executeQuery();
    ArrayList<Fournisseur> fournisseurList = new ArrayList<>();

    while (rs.next()) {
      Fournisseur fournisseur = new Fournisseur(rs.getString("nom"),rs.getString("prenom"),rs.getInt("num"),rs.getString("categorie_produit"));
      fournisseurList.add(fournisseur);
    }
    rs.close();
    ps.close();

    List<Fournisseur> filtred;
    filtred = fournisseurList.stream().sorted(Comparator.comparing(Fournisseur::getNom)).collect(Collectors.toList());

    return filtred;
  }

  public static void main(String[] args) throws SQLException {
  FournisseurService fournisseurService = new FournisseurService();
      //fournisseurService.addFournisseur("anas","visage","55555");
      //fournisseurService.addFournisseur("mohen","hair","888");
      //fournisseurService.addFournisseur("yamen","eyes","77777777");
    //fournisseurService.updateFournisseur(Integer.valueOf(1),"test1","test2");

    System.out.println(fournisseurService.getAllFournisseur());
    System.out.println(fournisseurService.getFournisseurSorted());
    System.out.println(fournisseurService.getFournisseurPerCategory("hair"));
  }

}
