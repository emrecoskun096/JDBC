import org.junit.Test;
import utilities.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunaRoomTest {

    //"john_doe" isimde kullanıcı tarafından oda oluşturmuş mu?

    @Test
    public void roomTest() throws SQLException {

        JdbcUtils.connectToDataBase(
                "medunna.com",
                "medunna_db",
                "medunna_user",
                "medunna_pass_987");

        Statement statement = JdbcUtils.createStatement();
        String sql01="select created_by from room";

        ResultSet resultSet1 = statement.executeQuery(sql01);
        List<String> created_byList = new ArrayList<>();

        while (resultSet1.next()){
            created_byList.add(resultSet1.getString(1));
        }
        System.out.println("ODA OLUSTURANLAR: " + created_byList);


    }
}