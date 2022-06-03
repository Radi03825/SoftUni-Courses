import java.util.Scanner;

public class fishTank_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = Integer.parseInt(scanner.nextLine());
        int weight = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double area = lenght * weight * height;
        double liters = area * 0.001;
        double totalLiters = liters - (liters * (percent / 100));

        System.out.printf("%.2f", totalLiters);


    }
}
