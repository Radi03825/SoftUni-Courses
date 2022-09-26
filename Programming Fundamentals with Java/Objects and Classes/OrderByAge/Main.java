import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");

            Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            people.add(person);

            command = scanner.nextLine();
        }

        people.stream().sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach(e -> System.out.printf("%s with ID: %s is %d years old.%n", e.getName(), e.getId(), e.getAge()));
    }
}
