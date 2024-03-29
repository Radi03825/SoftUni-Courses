import java.util.Scanner;

public class _10_HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int biggestNumber = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            if (number >= biggestNumber) {
                biggestNumber = number;
            }
        }
        sum -= biggestNumber;
        if (sum == biggestNumber) {
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum);
        } else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(biggestNumber - sum));
        }
    }
}
