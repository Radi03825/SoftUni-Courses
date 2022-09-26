import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            people.add(person);
        }

        people.stream()
                .filter(e -> e.getAge() > 30).sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(e -> System.out.printf("%s - %d%n", e.getName(), e.getAge()));
    }
}
