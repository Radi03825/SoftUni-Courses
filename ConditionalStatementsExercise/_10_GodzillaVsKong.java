import java.util.Scanner;

public class _10_GodzillaVsKong {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int extras = Integer.parseInt(scanner.nextLine());
        double priceForOne = Double.parseDouble(scanner.nextLine());

        double decor = budget * 0.10;
        double clothes = extras * priceForOne;

        if(extras >= 150){
            clothes *= 0.90;
        }

        double total = decor + clothes;
        double moneyLeft = budget - total;
        if(moneyLeft >= 0) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", moneyLeft);
        }else {
            moneyLeft = Math.abs(moneyLeft);
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", moneyLeft);
        }
    }
}
