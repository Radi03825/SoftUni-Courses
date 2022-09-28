import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(scanner.nextLine());

        Function<List<Integer>, List<Integer>> filter = list -> list.stream().filter(e -> e % n != 0).collect(Collectors.toList());

        Consumer<List<Integer>> print = list -> list.stream().forEach(e -> System.out.print(e + " "));

        input = filter.apply(input);
        Collections.reverse(input);

        print.accept(input);

    }
}
