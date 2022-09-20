import java.util.Scanner;

public class _06_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int grade = 1;
        int errors = 0;
        double average = 0;
        boolean excluded = false;

        while (true){
            double mark = Double.parseDouble(scanner.nextLine());
            if(mark < 4){
                errors++;
            }else {
                average += mark;
                grade++;
            }
            if(errors == 2){
                excluded = true;
                System.out.printf("%s has been excluded at %d grade", name, grade);
                break;
            }
            if(grade == 13){
                break;
            }
        }
        if(!excluded){
            double finalMark = average / (grade - 1);
            System.out.printf("%s graduated. Average grade: %.2f", name, finalMark);
        }

    }
}
