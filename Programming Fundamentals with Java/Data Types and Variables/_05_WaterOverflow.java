import java.util.Scanner;

public class _05_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int capacity = 0;

        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            if(capacity + liters > 255){
                System.out.println("Insufficient capacity!");
            }else {
                capacity += liters;
            }
        }

        System.out.println(capacity);
    }
}
