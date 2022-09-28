import java.util.Arrays;
import java.util.Scanner;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int min = Arrays.stream(input).min().orElse(0);
        System.out.println(min);
    }
}
