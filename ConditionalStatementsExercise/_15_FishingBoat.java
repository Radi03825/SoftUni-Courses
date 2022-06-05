import java.util.Scanner;

public class _15_FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if(season.equals("Spring")){
            price = 3000;
        }else if(season.equals("Summer") || season.equals("Autumn")){
            price = 4200;
        }else if(season.equals("Winter")){
            price = 2600;
        }

        if(fishers <= 6){
            price *= 0.90;
        }else if(fishers >= 7 && fishers <= 11){
            price *= 0.85;
        }else if(fishers >= 12){
            price *= 0.75;
        }

        if(fishers % 2 == 0){
            if(season.equals("Autumn")){
                price = price;
            }else {
                price *= 0.95;
            }
        }

        if(budget >= price){
            double moneyLeft = budget - price;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        }else {
            double moneyNeed = price - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeed);
        }
    }
}
