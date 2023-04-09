package service;

import entite.Produit;
import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements IService<Produit> {


  @Override
  public void ajouter(Produit produit) throws SQLException {

  }

  @Override
  public boolean supprimer(Produit produit) throws SQLException {
    return false;
  }

  @Override
  public boolean modifier(Produit produit) throws SQLException {
    return false;
  }

  @Override
  public List<Produit> readAll() throws SQLException {
    return null;
  }

  @Override
  public Produit findbyId(int id) throws SQLException {
    return null;
  }
}
