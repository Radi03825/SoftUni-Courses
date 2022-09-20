import java.util.Scanner;

public class _02_Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String pass = scanner.nextLine();
        String pass2 = scanner.nextLine();
        while(!pass.equals(pass2)){
            pass2 = scanner.nextLine();
        }
        System.out.printf("Welcome %s!", name);
    }
}
