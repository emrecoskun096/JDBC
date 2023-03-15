package pojos;

public class Doctor {

    private int id;
    private String isim;
    private String bolum;
    private double ucret;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public double getUcret() {
        return ucret;
    }

    public void setUcret(double ucret) {
        this.ucret = ucret;
    }

    public Doctor(int id, String isim, String bolum, double ucret) {
        this.id = id;
        this.isim = isim;
        this.bolum = bolum;
        this.ucret = ucret;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ucret=" + ucret +
                '}';
    }
}
