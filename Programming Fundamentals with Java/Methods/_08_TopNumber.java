import java.util.Scanner;

public class _08_TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= range; i++) {
            if(divideByEight(i) && hasOdd(i)){
                System.out.println(i);
            }
        }

    }

    private static boolean hasOdd(int number) {
        int oddCount = 0;
        while (number > 0){
            if((number % 10) % 2 != 0){
                oddCount++;
            }
            number /= 10;
        }
        if(oddCount >= 1){
            return true;
        }
        return false;
    }

    private static boolean divideByEight(int number) {
        int sum = 0;
        while (number > 0){
            sum += number % 10;
            number /= 10;
        }
        if(sum % 8 == 0){
            return true;
        }
        return false;
    }
}
