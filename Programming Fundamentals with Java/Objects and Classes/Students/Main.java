import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Student student = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            studentList.add(student);
        }

        studentList.stream().sorted((a, b) -> Double.compare(b.getGrade(), a.getGrade())).forEach(e -> System.out.printf("%s %s: %.2f%n", e.getFirstName(), e.getLastName(), e.getGrade()));
    }
}
