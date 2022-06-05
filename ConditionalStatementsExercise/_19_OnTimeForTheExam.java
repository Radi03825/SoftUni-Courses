import java.util.Scanner;

public class _19_OnTimeForTheExam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour1 = Integer.parseInt(scanner.nextLine());
        int min1 = Integer.parseInt(scanner.nextLine());
        int hour2 = Integer.parseInt(scanner.nextLine());
        int min2 = Integer.parseInt(scanner.nextLine());

        int timeExam = hour1 * 60 + min1;
        int timeStudent = hour2 * 60 + min2;
        int difference = timeExam - timeStudent;

        if(difference <= 30 && difference > 0){
            System.out.println("On time");
            System.out.printf("%d minutes before the start", difference);
        }else if(difference == 0){
            System.out.println("On time");
        }else if(difference > 0 && difference <= 59){
            System.out.println("Early");
            System.out.printf("%d minutes before the start", difference);
        }else if(difference >= 60){
            int hour = Math.abs(difference / 60);
            int min = difference % 60;
            if(min <= 9){
                System.out.println("Early");
                System.out.printf("%d:0%d hours before the start", hour, min);
            }else {
                System.out.println("Early");
                System.out.printf("%d:%d hours before the start", hour, min);
            }
        }else if(difference < 0 && difference > -60){
            difference *= -1;
            System.out.println("Late");
            System.out.printf("%d minutes after the start", difference);
        }else if(difference <= -60){
            difference *= -1;
            int hour = Math.abs(difference / 60);
            int min = difference % 60;
            if(min <= 9){
                System.out.println("Late");
                System.out.printf("%d:0%d hours after the start", hour, min);
            }else {
                System.out.println("Late");
                System.out.printf("%d:%d hours after the start", hour, min);
            }
        }

    }
}
