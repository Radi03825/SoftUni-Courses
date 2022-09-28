import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        ArrayDeque<Integer> integers = new ArrayDeque<>();

        for (int i = 0; i < numbers.size(); i++) {
            integers.push(numbers.get(i));
        }

        while (!integers.isEmpty()){
            System.out.print(integers.pop() + " ");
        }

    }
}
