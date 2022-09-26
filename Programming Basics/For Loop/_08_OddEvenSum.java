import java.util.Scanner;

public class _08_OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++){
            int n1 = Integer.parseInt(scanner.nextLine());
            if(i % 2 == 0) {
                sum1 += n1;
            }else {
                sum2 += n1;
            }
        }
        if(sum1 == sum2){
            System.out.println("Yes");
            System.out.printf("Sum = %d", sum1);
        }else {
            System.out.println("No");
            System.out.printf("Diff = %d", Math.abs(sum1 - sum2));
        }
    }
}
