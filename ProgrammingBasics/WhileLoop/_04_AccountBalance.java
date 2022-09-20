import java.util.Scanner;

public class _04_AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalMoney = 0;

        while(true){
            String command = scanner.nextLine();
            if(command.equals("NoMoreMoney")){
                System.out.printf("Total: %.2f", totalMoney);
                break;
            }else {
                double money = Double.parseDouble(command);
                if(money > 0){
                    totalMoney += money;
                    System.out.printf("Increase: %.2f", money);
                    System.out.println();
                }else {
                    System.out.println("Invalid operation!");
                    System.out.printf("Total: %.2f", totalMoney);
                    break;
                }
            }

        }
    }
}
