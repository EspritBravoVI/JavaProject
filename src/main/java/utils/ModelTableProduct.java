package utils;
public class ModelTableProduct {
      String des, catg;
    Integer Qte ;

    public Integer getQte() {
        return Qte;
    }

    public void setQte(Integer Qte) {
        this.Qte = Qte;
    }

    public ModelTableProduct(String des, String catg,Integer qte ) {
        this.des = des;
        this.catg = catg;
        this.Qte=qte;

    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public String getCatg() {
        return catg;
    }

    public void setCatg(String dateexp) {
        this.catg = catg;
    }


}
