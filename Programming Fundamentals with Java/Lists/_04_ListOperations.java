import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Remove": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index <= numbers.size() - 1) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case "Insert": {
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= numbers.size() - 1) {
                        int insertNumber = Integer.parseInt(tokens[1]);
                        numbers.add(index, insertNumber);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                }
                case "Shift":
                    int count = Integer.parseInt(tokens[2]);
                    switch (tokens[1]) {
                        case "left":
                            for (int i = 0; i < count; i++) {
                                int firstNumber = numbers.get(0);
                                numbers.remove(0);
                                numbers.add(firstNumber);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < count; i++) {
                                int lastNumber = numbers.get(numbers.size() - 1);
                                numbers.remove(numbers.size() - 1);
                                numbers.add(0, lastNumber);
                            }
                            break;
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
