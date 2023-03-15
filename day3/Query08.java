import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "12345");
        Statement st = con.createStatement();

        //Doktors tablosunu oluşturu.
        String sql01 = "create table doctors (id int, isim varchar(30), bolum varchar(20), ucret int)";
        st.execute(sql01);

        //Pojo class kullanarak tabloya data ekelyiniz
        List<Doctor> kayitlar = new ArrayList<>();
        kayitlar.add(new Doctor(20, "Ali Can", "Dahiliye", 500));
        kayitlar.add(new Doctor(21, "Veli Can", "KBB", 600));
        kayitlar.add(new Doctor(22, "Ahmet Can", "Dahiliye", 500));
        kayitlar.add(new Doctor(23, "Ali Can", "Dahiliye", 800));
        kayitlar.add(new Doctor(24, "Ali Can", "KBB", 400));
        kayitlar.add(new Doctor(25, "Ali Can", "Dahiliye", 500));
        kayitlar.add(new Doctor(26, "Ali Can", "Psikoloji", 500));
        kayitlar.add(new Doctor(27, "Ali Can", "Dahiliye", 200));
        kayitlar.add(new Doctor(28, "Ali Can", "Dahiliye", 300));
        kayitlar.add(new Doctor(29, "Ali Can", "Cildiye", 500));

        PreparedStatement data = con.prepareStatement("insert into doctors values (?, ?, ?, ?)");

        for(Doctor each: kayitlar){
            data.setInt(1, each.getId());   //20
            data.setString(2, each.getIsim());  //Ali Can
            data.setString(3, each.getBolum()); //Dahiliye
            data.setDouble(4, each.getUcret()); //500
            data.addBatch();
        }
        data.executeBatch();
        con.close();
        data.close();

    }
}