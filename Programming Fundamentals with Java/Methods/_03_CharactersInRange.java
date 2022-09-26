import java.util.Scanner;

public class _03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printChars(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
    }

    private static void printChars(char start, char end) {
        if(start < end){
            for (int i = start + 1; i < end; i++) {
                System.out.print((char)i + " ");
            }
        }else {
            for (int i = end + 1; i < start; i++) {
                System.out.print((char)i + " ");
            }
        }
    }
}
