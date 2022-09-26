import java.util.Scanner;

public class _02_SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        System.out.println(sum);
    }
}
