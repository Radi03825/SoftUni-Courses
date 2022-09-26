import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagon = Arrays.stream(scanner.nextLine().split(" ")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        int capacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] tokens = command.split(" ");
            if(tokens[0].equals("Add")){
                wagon.add(Integer.parseInt(tokens[1]));
            }else {
                int number = Integer.parseInt(tokens[0]);
                for (int i = 0; i < wagon.size(); i++) {
                    int sum = wagon.get(i) + number;
                    if(sum <= capacity){
                        wagon.set(i, sum);
                        break;
                    }
                }
            }

            command = scanner.nextLine();
        }

        wagon.forEach(e -> System.out.print(e + " "));

    }
}
