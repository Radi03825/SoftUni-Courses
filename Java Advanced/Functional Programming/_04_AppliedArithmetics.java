import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class _04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();


        String command = scanner.nextLine();


        Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e += 1).toArray();
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e *= 2).toArray();
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e -= 1).toArray();
        Consumer<int[]> print = array -> Arrays.stream(array).forEach(e -> System.out.print(e + " "));

        while (!command.equals("end")){
            if(command.equals("add")){
                input = add.apply(input);
            }else if(command.equals("multiply")){
                input = multiply.apply(input);
            }else if(command.equals("subtract")){
                input = subtract.apply(input);
            }else if(command.equals("print")){
                print.accept(input);
                System.out.println();
            }

            command = scanner.nextLine();
        }
    }
}
