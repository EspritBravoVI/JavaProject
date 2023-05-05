package entite;

public class Fournisseur {
    private Integer id ;
    private Integer num ;
    private String nom;
    private String prenom;
    private String categorie ;

    public Fournisseur(String nom, String prenom, Integer num, String categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.categorie = categorie;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", num='" + num + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", Categorie='" + categorie + '\'' +
                '}';
    }



}
