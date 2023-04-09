package entite;

public class Produit {
  private String libelle, categorie;
  private Integer quantite;

  public Produit(String libelle, String categorie, Integer quantite) {
    this.libelle = libelle;
    this.categorie = categorie;
    this.quantite = quantite;
  }

  public Produit() {
  }

  public String getLibelle() {
    return libelle;
  }

  public String getCategorie() {
    return categorie;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
  }

  public Integer getQuantite() {
    return quantite;
  }
}
