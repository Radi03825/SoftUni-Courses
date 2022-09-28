import java.util.Arrays;
import java.util.Scanner;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = Arrays.stream(scanner.nextLine().split("\\s+")).toArray(String[]::new);

        Arrays.stream(input).forEach(e -> System.out.println("Sir " + e));
    }
}
