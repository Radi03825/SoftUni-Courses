import java.util.Scanner;

public class _03_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while(number > sum){
            int n = Integer.parseInt(scanner.nextLine());
            sum += n;
        }
        System.out.println(sum);
    }
}
