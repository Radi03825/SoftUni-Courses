import java.util.Scanner;

public class _05_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= numbers; i++){
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);
    }
}
