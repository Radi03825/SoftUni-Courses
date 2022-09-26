import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] train = new int[n];
        int sum = 0;

        for (int i = 0; i < train.length; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            sum += number;
            train[i] = number;
        }

        for (int i : train) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(sum);

    }
}
