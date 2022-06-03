import java.util.Scanner;

public class depositCalculator_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depSum = Double.parseDouble(scanner.nextLine());
        int term = Integer.parseInt(scanner.nextLine());
        double procent = Double.parseDouble(scanner.nextLine());

        double divident = depSum * (procent / 100);
        double dividentPerMonth = divident / 12;
        double sum = depSum + (term * dividentPerMonth);
        System.out.println(sum);

    }
}
