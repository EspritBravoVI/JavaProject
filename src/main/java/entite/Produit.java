package entite;

public class Produit {
  private String description, categorie, dateExpiration;
  private Integer quantite;

  public Produit(String description, String categorie, String dateExpiration, Integer quantite) {
    this.description = description;
    this.categorie = categorie;
    this.dateExpiration = dateExpiration;
    this.quantite = quantite;
  }

  public Produit() {
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCategorie(String categorie) {
    this.categorie = categorie;
  }

  public void setDateExpiration(String dateExpiration) {
    this.dateExpiration = dateExpiration;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
  }

  public String getDescription() {
    return description;
  }

  public String getCategorie() {
    return categorie;
  }

  public String getDateExpiration() {
    return dateExpiration;
  }

  public Integer getQuantite() {
    return quantite;
  }
}
