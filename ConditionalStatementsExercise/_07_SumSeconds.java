import java.util.Scanner;

public class _07_SumSeconds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int sum = n1 + n2 + n3;
        int min = sum / 60;
        int sec = sum % 60;

        if(sec > 9) {
            System.out.printf("%d:%d", min, sec);
        }else {
            System.out.printf("%d:0%d", min, sec);
        }


    }
}
