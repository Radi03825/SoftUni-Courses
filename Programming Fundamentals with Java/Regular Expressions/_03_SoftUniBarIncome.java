import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Pattern pattern = Pattern.compile("%(?<customer>[A-Z][a-z]+)%[^|%$.]*<(?<product>\\w+)>[^|%$.]*\\|(?<count>\\d+)\\|[^|%$.\\d]*(?<price>\\d+\\.?\\d*)\\$");

        double totalPrice = 0.0;
        while (!command.equals("end of shift")){

            Matcher matcher = pattern.matcher(command);
            if(matcher.find()){
                int quantity = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double currentTotalPrice = quantity * price;
                totalPrice += currentTotalPrice;
                System.out.printf("%s: %s - %.2f%n", matcher.group("customer"), matcher.group("product"), currentTotalPrice);
            }

            command = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f%n", totalPrice);
    }
}
