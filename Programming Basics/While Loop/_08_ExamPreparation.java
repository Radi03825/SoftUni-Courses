import java.util.Scanner;

public class _08_ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int poorMark = Integer.parseInt(scanner.nextLine());
        int poorMarkCount = 0;
        double sum = 0;
        int problemsCount = 0;
        String lastProblem = "";

        while (poorMark > poorMarkCount){
            String problemName = scanner.nextLine();
            if(problemName.equals("Enough")){
                break;
            }
            int mark = Integer.parseInt(scanner.nextLine());
            if(mark <= 4){
                poorMarkCount++;
            }
            lastProblem = problemName;
            sum += mark;
            problemsCount++;
        }
        if(poorMark > poorMarkCount) {
            System.out.printf("Average score: %.2f%n", sum / problemsCount);
            System.out.printf("Number of problems: %d%n", problemsCount);
            System.out.printf("Last problem: %s", lastProblem);
        }else {
            System.out.printf("You need a break, %d poor grades.", poorMarkCount);
        }

    }
}
