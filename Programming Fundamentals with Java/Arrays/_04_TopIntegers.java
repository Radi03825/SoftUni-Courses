import java.util.Arrays;
import java.util.Scanner;

public class _04_TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < array.length; i++) {
            boolean isBigger = true;
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] <= array[j]){
                    isBigger = false;
                    break;
                }
            }
            if(isBigger) {
                System.out.print(array[i] + " ");
            }
        }

    }
}
