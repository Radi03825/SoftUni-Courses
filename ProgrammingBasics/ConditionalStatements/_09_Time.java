import java.util.Scanner;

public class _09_Time {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        int finalMin = min + 15;
        if(finalMin >= 60){
            hour = (finalMin / 60) + hour;
            finalMin %= 60;
        }
        if(hour > 23){
            hour = 0;
        }
        if(finalMin > 9){
            System.out.printf("%d:%d", hour, finalMin);
        }else {
            System.out.printf("%d:0%d", hour, finalMin);
        }


    }
}
