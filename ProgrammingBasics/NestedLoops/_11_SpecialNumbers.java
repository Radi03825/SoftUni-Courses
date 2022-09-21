import java.util.Scanner;

public class _11_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;

        for (int n = 1111; n <= 9999; n++){
            int p = n;
            while (p > 0){
                int digit = p % 10;
                if(digit == 0){
                    break;
                }
                p /= 10;
                if(number % digit == 0){
                    count++;
                }
            }
            if(count == 4){
                System.out.printf("%d ", n);
            }
            count = 0;
        }
    }
}
