import java.util.Scanner;

public class radiansToDegrees_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double rad = Double.parseDouble(scanner.nextLine());
        double pi = Math.PI;
        double deg = rad * 180 / pi;
        System.out.printf("%.0f", deg);

    }
}
