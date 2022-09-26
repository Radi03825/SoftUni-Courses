import java.util.Scanner;

public class _01_Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int hour = 0; hour < 24; hour++){
            for (int min = 0; min < 60; min++){
                System.out.printf("%d:%d%n", hour, min);
            }
        }
    }
}
