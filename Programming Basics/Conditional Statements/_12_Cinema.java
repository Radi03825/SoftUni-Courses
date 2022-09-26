import java.util.Scanner;

public class _12_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticketType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double price = 0;
        if (ticketType.equals("Premiere")){
            price = 12;
        }else if(ticketType.equals("Normal")){
            price = 7.50;
        }else if(ticketType.equals("Discount")){
            price = 5;
        }

        double totalSum = price * rows * columns;

        System.out.printf("%.2f leva", totalSum);

    }
}
