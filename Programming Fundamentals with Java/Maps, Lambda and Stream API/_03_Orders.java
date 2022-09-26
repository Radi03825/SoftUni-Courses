import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("buy")){
            String[] order = command.split(" ");
            double price = Double.parseDouble(order[1]);
            int quantity = Integer.parseInt(order[2]);

            productPrice.put(order[0], price);

            if(productQuantity.containsKey(order[0])){
                productQuantity.put(order[0], productQuantity.get(order[0]) + quantity);
            }else {
                productQuantity.put(order[0], quantity);
            }

            command = scanner.nextLine();
        }


        for (Map.Entry<String, Integer> entry : productQuantity.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue() * productPrice.get(entry.getKey()));
        }
    }
}
