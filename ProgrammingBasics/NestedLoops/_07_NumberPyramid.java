import java.util.Scanner;

public class _07_NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int current = 1;
        boolean isBigger = false;
        for (int a = 1; a <= n; a++){
            for (int b = 1; b <= a; b++){
                if(current > n){
                    isBigger = true;
                    break;
                }
                System.out.printf("%d ", current);
                current++;
            }
            if(isBigger){
                break;
            }
            System.out.println();
        }
    }
}
