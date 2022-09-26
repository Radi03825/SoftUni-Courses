import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String[] numbers = scanner.nextLine().split("\\s+");
        int magicNumber = Integer.parseInt(numbers[0]);
        int range = Integer.parseInt(numbers[1]);


        while (list.contains(magicNumber)){
            int bombPosition = list.indexOf(magicNumber);

            int leftBound = Math.max(0, bombPosition - range);
            int rightBound = Math.min(list.size() - 1, bombPosition + range);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);
            }
        }

        int sum = 0;

        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }
}
