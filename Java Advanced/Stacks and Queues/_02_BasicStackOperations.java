import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(tokens[0]);
        int S = Integer.parseInt(tokens[1]);
        int X = Integer.parseInt(tokens[2]);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).limit(N).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        ArrayDeque<Integer> integers = new ArrayDeque<>();

        for (int i = 0; i < numbers.size(); i++) {
            integers.push(numbers.get(i));
        }

        for (int i = 0; i < S; i++) {
            integers.pop();
        }

        if(integers.contains(X)){
            System.out.println("true");
        }else {
            int smallest = Integer.MAX_VALUE;

            if(integers.isEmpty()){
                smallest = 0;
            }

            while (!integers.isEmpty()){
                int current = integers.pop();

                if(current < smallest){
                    smallest = current;
                }
            }
            System.out.println(smallest);
        }

    }
}
