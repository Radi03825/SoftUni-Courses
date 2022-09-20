import java.util.Scanner;

public class _03_CharacterSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            System.out.println();
        }
    }
}
