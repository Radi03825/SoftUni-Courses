import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        String input = scanner.nextLine();
        String sql = String.format("UPDATE minions\n" +
                "SET age = age + 1, name = lower(name)\n" +
                "WHERE id IN (%s);", input.trim().replace(" ", ", "));

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.executeUpdate();

        PreparedStatement st = connection.prepareStatement("SELECT name, age FROM minions;");

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(name + " " + age);
        }

    }
}
