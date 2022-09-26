import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> gradesTotalSum = new HashMap<>();
        Map<String, Integer> gradesCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int count = 1;
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if(gradesTotalSum.containsKey(name)){
                grade += gradesTotalSum.get(name);
                count = gradesCount.get(name) + 1;
            }
            gradesTotalSum.put(name, grade);
            gradesCount.put(name, count);
        }

        Map<String, Double> averageGrades = new HashMap<>();
        for (Map.Entry<String, Double> entry : gradesTotalSum.entrySet()) {
            double finalGrade = entry.getValue() / gradesCount.get(entry.getKey());
            averageGrades.put(entry.getKey(), finalGrade);
        }
        averageGrades.entrySet().stream().filter(e -> e.getValue() >= 4.5)
                .sorted((f, s) -> Double.compare(s.getValue(), f.getValue()))
                .forEach(gr -> System.out.printf("%s -> %.2f%n", gr.getKey(), gr.getValue()));
    }
}
