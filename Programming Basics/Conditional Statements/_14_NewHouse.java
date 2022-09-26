import java.util.Scanner;

public class _14_NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowersType = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if(flowersType.equals("Roses")){
            price = quantity * 5.0;
            if(quantity > 80){
                price *= 0.90;
            }
        }else if(flowersType.equals("Dahlias")){
            price = quantity * 3.80;
            if(quantity > 90){
                price *= 0.85;
            }
        }else if(flowersType.equals("Tulips")){
            price = quantity * 2.80;
            if(quantity > 80){
                price *= 0.85;
            }
        }else if(flowersType.equals("Narcissus")){
            price = quantity * 3.0;
            if(quantity < 120){
                price *= 1.15;
            }
        }else if(flowersType.equals("Gladiolus")){
            price = quantity * 2.50;
            if(quantity < 80){
                price *= 1.20;
            }
        }

        if(budget >= price){
            double moneyLeft = budget - price;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantity, flowersType, moneyLeft);
        }else {
            double moneyNeed = price - budget;
            System.out.printf("Not enough money, you need %.2f leva more.",moneyNeed);
        }
    }
}
