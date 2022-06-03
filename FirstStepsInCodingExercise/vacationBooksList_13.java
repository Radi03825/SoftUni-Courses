import java.util.Scanner;

public class vacationBooksList_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pages = Integer.parseInt(scanner.nextLine());
        int pagesPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int hours = (pages / pagesPerHour) / days;
        System.out.println(hours);


    }
}
