import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "12345");
        Statement st = con.createStatement();

        // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        //String sql01 = "create table urunler (id int, isim varchar(10), fiyat int)";
        //st.execute(sql01);

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(100, "Laptop", 35000));
        kayitlar.add(new Urun(101, "IPad", 25000));
        kayitlar.add(new Urun(102, "MacBook", 55000));
        kayitlar.add(new Urun(103, "AnaKart", 15000));
        kayitlar.add(new Urun(104, "IMac", 15000));
        kayitlar.add(new Urun(105, "IPhone", 45000));

        //Çok miktarda data eklemek için PreparedStatment kullanmalıyız
        PreparedStatement tablo = con.prepareStatement("insert into urunler values (?, ?, ?)");

        for(Urun each:kayitlar){
            tablo.setInt(1, each.getId());          //id: 100
            tablo.setString(2, each.getIsim());     // isim: Laptop
            tablo.setDouble(3, each.getFiyat());    //fiyat: 35000
            tablo.addBatch();                                   //Bütün dataları birleştiriyor
        }
        tablo.executeBatch();
    }
}
