import java.util.Arrays;
import java.util.Scanner;

public class _01_ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);

        Arrays.stream(input).forEach(System.out::println);
    }
}
