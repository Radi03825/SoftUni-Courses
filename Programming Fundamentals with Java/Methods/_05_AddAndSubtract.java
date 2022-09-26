import java.util.Scanner;

public class _05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstN = Integer.parseInt(scanner.nextLine());
        int secondN = Integer.parseInt(scanner.nextLine());
        int thirdN = Integer.parseInt(scanner.nextLine());

        int sum = sumMethod(firstN, secondN);
        int finalNumber = substractMethod(sum, thirdN);
        System.out.println(finalNumber);
    }

    private static int substractMethod(int a, int b) {
        int sum = a - b;
        return sum;
    }

    private static int sumMethod(int a, int b) {
        int sum = a + b;
        return sum;
    }

}
