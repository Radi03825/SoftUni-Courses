import java.util.Scanner;

public class _05_Traveling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String destination = scanner.nextLine();
        while (!destination.equals("End")){
            double budget = Double.parseDouble(scanner.nextLine());
            double money = 0;
            while (money < budget){
                double moneySaved = Double.parseDouble(scanner.nextLine());
                money += moneySaved;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scanner.nextLine();
        }
    }
}
