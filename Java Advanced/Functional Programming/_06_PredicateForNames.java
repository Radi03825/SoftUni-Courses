import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayList::new));

        Predicate<String> predicate = s -> s.length() <= n;

        input.stream().filter(predicate).forEach(System.out::println);

    }
}
