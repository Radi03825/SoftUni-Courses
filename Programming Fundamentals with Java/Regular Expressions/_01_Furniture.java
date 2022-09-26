import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Pattern pattern = Pattern.compile(">>(?<product>\\w+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)");

        double totalPrice = 0.0;

        List<String> products = new ArrayList<>();

        while (!command.equals("Purchase")){
            Matcher matcher = pattern.matcher(command);
            if(matcher.find()){
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                totalPrice += price * quantity;

                products.add(matcher.group("product"));
            }
            command = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        products.forEach(e -> System.out.println(e));
        System.out.printf("Total money spend: %.2f%n", totalPrice);

    }
}
