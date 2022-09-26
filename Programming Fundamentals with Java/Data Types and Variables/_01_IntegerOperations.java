import java.util.Scanner;

public class _01_IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int divideNumber = Integer.parseInt(scanner.nextLine());
        int multiplyNumber = Integer.parseInt(scanner.nextLine());

        int sum = ((firstNumber + secondNumber) / divideNumber) * multiplyNumber;
        System.out.println(sum);
    }
}
