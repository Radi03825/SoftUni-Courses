import java.util.Scanner;

public class _10_TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int jury = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        double totalGrade = 0;
        int counter = 0;
        while (!name.equals("Finish")) {
            double grade = 0;
            for (int a = 0; a < jury; a++) {
                double mark = Double.parseDouble(scanner.nextLine());
                grade += mark;
                totalGrade += mark;
                counter++;
            }
            System.out.printf("%s - %.2f.%n", name, grade / jury);
            name = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrade / counter);
    }
}
