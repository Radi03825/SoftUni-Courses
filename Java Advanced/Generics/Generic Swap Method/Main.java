import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        while (n-- > 0){
            int input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();

        box.swap(indexes[0], indexes[1]);

        System.out.println(box);
    }
}
