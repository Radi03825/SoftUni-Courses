import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> smallestInt = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            smallestInt.add(number);
        }

        smallestInt.stream().sorted((f, s) -> f.compareTo(s)).limit(1)
                .forEach(e -> System.out.println(e));
    }
}
