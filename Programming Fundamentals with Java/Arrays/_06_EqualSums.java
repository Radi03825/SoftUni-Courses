import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += array[j];
            }

            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }

            if(leftSum == rightSum) {
                System.out.println(i);
                isFound = true;
                break;
            }
        }

        if(!isFound) {
            System.out.println("no");
        }

    }
}
