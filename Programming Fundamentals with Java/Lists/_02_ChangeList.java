import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(e -> Integer.parseInt(e)).collect(Collectors.toList());

        String command = scanner.nextLine();
        while (!command.equals("end")){
            String[] tokens = command.split("\\s+");
            String firstToken = tokens[0];
            int element = Integer.parseInt(tokens[1]);
            if(firstToken.equals("Delete")){
                list.removeAll(List.of(element));
            }else if(firstToken.equals("Insert")){
                int index = Integer.parseInt(tokens[2]);
                list.add(index, element);
            }

            command = scanner.nextLine();
        }

        list.forEach(e -> System.out.print(e + " "));

    }
}
