import java.util.Scanner;

public class _06_Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        int lastFloor = floors;

        for (int a = floors; a >= 1; a--){
            for (int b = 0; b < rooms; b++){
                if(a == lastFloor){
                    System.out.printf("L%d%d ", a, b);
                }else if(a % 2 == 0){
                    System.out.printf("O%d%d ", a, b);
                }else {
                    System.out.printf("A%d%d ", a, b);
                }
            }
            System.out.println();
        }
    }
}
