import static utilities.DatabaseUtilty.*;

public class Query09 {

    public static void main(String[] args) {

        /*
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "12345");
         */


        createConnection();

        String sql01="select * from ogrenciler";
        System.out.println("Sütun isimleri: " + getColumnNames(sql01));

        System.out.println("Okul No: " + getColumnData(sql01, "okul_no"));
        System.out.println("ogrenci_ismi: " + getColumnData(sql01, "ogrenci_ismi"));
        System.out.println("sinif: "+ getColumnData(sql01, "sinif"));
        System.out.println("cinsiyet: " + getColumnData(sql01, "cinsiyet"));


        closeConnection();

    }
}
