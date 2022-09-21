import java.util.Scanner;

public class _08_EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        for (int a = number; a <= number2; a++){
            int n = a;
            boolean isEven = true;
            int evenSum = 0;
            int oddSum = 0;
            while (n > 0){
                int digit = n % 10;
                n /= 10;
                if(isEven){
                    evenSum += digit;
                    isEven = false;
                }else {
                    oddSum += digit;
                    isEven = true;
                }
            }
            if(evenSum == oddSum){
                System.out.printf("%d ", a);
            }
        }

    }
}
