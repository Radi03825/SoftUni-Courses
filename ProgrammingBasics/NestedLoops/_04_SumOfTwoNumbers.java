import java.util.Scanner;

public class _04_SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;
        boolean isFound = false;
        int d = 0;
        int b = 0;


        for (int a = start; a <= end; a++) {
            for (int c = start; c <= end; c++) {
                count++;
                if (a + c == number) {
                    d = a;
                    b = c;
                    isFound = true;
                    break;
                }
            }
            if(isFound){
                break;
            }
        }
        if (isFound) {
            System.out.printf("Combination N:%d (%d + %d = %d)", count, d, b, number);
        }else {
            System.out.printf("%d combinations - neither equals %d", count, number);
        }

    }
}
