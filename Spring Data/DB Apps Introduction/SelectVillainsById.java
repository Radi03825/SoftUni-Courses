import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class SelectVillainsById {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT v.name, m.name, m.age FROM villains as v JOIN minions_villains as mv ON v.id = mv.villain_id\n" +
                "JOIN minions as m ON mv.minion_id = m.id\n" +
                "WHERE v.id = ?;");

        int id = Integer.parseInt(scanner.nextLine());

        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (!resultSet.next()) {
            System.out.printf("No villain with ID %d exists in the database.", id);
            return;
        }else {
            System.out.println("Villain: " + resultSet.getString("v.name"));
            String name = resultSet.getString("m.name");
            String age = resultSet.getString("m.age");

            System.out.println("1. " + name + " " + age);
        }

        for (int i = 2; resultSet.next(); i++) {
            String name = resultSet.getString("m.name");
            String age = resultSet.getString("m.age");

            System.out.println(i + ". " + name + " " + age);
        }

        connection.close();
    }
}
