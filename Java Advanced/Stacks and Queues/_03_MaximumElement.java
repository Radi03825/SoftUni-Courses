import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    stack.push(Integer.parseInt(tokens[1]));
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maximum = Integer.MIN_VALUE;
                    for (Integer integer : stack) {
                        if(integer > maximum){
                            maximum = integer;
                        }
                    }
                    System.out.println(maximum);

                    break;
            }
        }

    }
}
