import java.util.Scanner;

public class _11_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lenght = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int cake = lenght * width;
        String command = scanner.nextLine();

        while (!command.equals("STOP")){
            int pieces = Integer.parseInt(command);
            cake -= pieces;
            if(cake < 0){
                break;
            }
            command = scanner.nextLine();
        }
        if(cake >= 0){
            System.out.printf("%d pieces are left.", cake);
        }else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cake));
        }
    }
}
