import java.util.Scanner;

public class _06_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());


        long firstFactorial = sumFactorial(firstNumber);
        long secondFactorial = sumFactorial(secondNumber);

        double sum = (double)firstFactorial / secondFactorial;
        System.out.printf("%.2f", sum);
    }

    private static long sumFactorial(int number) {
        long sum = 1;
        for (int i = 1; i <= number; i++) {
            sum *= i;
        }
        return sum;
    }
}
