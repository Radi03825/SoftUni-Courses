import javax.xml.transform.Result;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ChangeTownNames {

    public static void main(String[] args) throws SQLException {


        Scanner scanner = new Scanner(System.in);

        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", properties);

        PreparedStatement statement = connection.prepareStatement("SELECT name FROM towns WHERE country = ?;");

        String country = scanner.nextLine();

        statement.setString(1, country);
        ResultSet resultSet =  statement.executeQuery();

        if (resultSet.next()) {
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE towns\n" +
                    "SET name = upper(name)\n" +
                    "WHERE country = ?;");
            updateStatement.setString(1, country);
            int lines = updateStatement.executeUpdate();

            ResultSet set =  statement.executeQuery();

            StringBuilder stringBuilder = new StringBuilder();

            while (set.next()) {
                stringBuilder.append(set.getString("name") + " ");
            }

            System.out.println(lines + " town names were affected.");
            System.out.println("[" + stringBuilder.toString().trim().replace(" ", ", ") + "]");

        }else  {
            System.out.println("No town names were affected.");
        }
    }
}
