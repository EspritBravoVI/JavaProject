package entite;

public class PointDeVente {
  private int id;
  private String localisation;
  public PointDeVente() {
  }

  public PointDeVente(int id, String localisation) {
    this.id = id;
    this.localisation = localisation;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  @Override
  public String toString() {
    return "PointDeVente{" +
      "id=" + id +
      ", localisation='" + localisation + '\'' +
      '}';
  }
}
