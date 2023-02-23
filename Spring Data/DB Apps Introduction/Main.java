import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT v.name, count(DISTINCT mv.minion_id) as 'minion_count' FROM villains as v JOIN minions_villains as mv ON v.id = mv.villain_id\n" +
                "GROUP BY mv.villain_id\n" +
                "HAVING minion_count > 15\n" +
                "ORDER BY minion_count DESC;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String count = resultSet.getString("minion_count");

            System.out.println(name + " " + count);
        }


        connection.close();
    }
}
