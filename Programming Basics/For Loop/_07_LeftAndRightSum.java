import java.util.Scanner;

public class _07_LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++){
            int n1 = Integer.parseInt(scanner.nextLine());
            sum1 += n1;
        }
        for (int i = 1; i <= n; i++){
            int n1 = Integer.parseInt(scanner.nextLine());
            sum2 += n1;
        }
        if(sum1 == sum2){
            System.out.printf("Yes, sum = %d", sum1);
        }else {
            System.out.printf("No, diff = %d", Math.abs(sum1 - sum2));
        }
    }
}
