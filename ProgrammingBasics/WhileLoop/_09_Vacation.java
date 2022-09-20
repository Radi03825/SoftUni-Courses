import java.util.Scanner;

public class _09_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyForTrip = Double.parseDouble(scanner.nextLine());
        double money = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        boolean fiveTimesInRow = false;
        int days = 0;

        while (money < moneyForTrip){
            String command = scanner.nextLine();
            double moneyForOperation = Double.parseDouble(scanner.nextLine());

            days++;

            if(command.equals("spend")){
                money -= moneyForOperation;
                if(money < 0){
                    money = 0;
                }
                spendCount++;
                if(spendCount == 5){
                    fiveTimesInRow = true;
                    break;
                }
            }else if(command.equals("save")) {
                money += moneyForOperation;
                spendCount = 0;
            }
        }
        if(money >= moneyForTrip){
            System.out.printf("You saved the money for %d days.", days);
        }else if(fiveTimesInRow){
            System.out.println("You can't save the money.");
            System.out.println(days);
        }
    }
}
