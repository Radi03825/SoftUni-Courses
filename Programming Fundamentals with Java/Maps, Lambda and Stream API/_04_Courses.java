import java.util.*;

public class _04_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] tokens = command.split(" : ");
            String course = tokens[0];
            String name = tokens[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
            }
            courses.get(course).add(name);

            command = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(s -> System.out.printf("-- %s%n", s));
                });
    }
}
