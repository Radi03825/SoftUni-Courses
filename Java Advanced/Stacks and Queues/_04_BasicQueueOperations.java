import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(tokens[0]);
        int S = Integer.parseInt(tokens[1]);
        int X = Integer.parseInt(tokens[2]);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).limit(N).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numbers.size(); i++) {
            queue.offer(numbers.get(i));
        }

        for (int i = 0; i < S; i++) {
            queue.poll();
        }

        if(queue.contains(X)){
            System.out.println("true");
        }else {
            int smallest = Integer.MAX_VALUE;

            if(queue.isEmpty()){
                smallest = 0;
            }

            while (!queue.isEmpty()){
                int current = queue.pop();

                if(current < smallest){
                    smallest = current;
                }
            }
            System.out.println(smallest);
        }

    }
}
