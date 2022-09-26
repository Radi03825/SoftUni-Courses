import java.util.Scanner;

public class _04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        for (int i = 0; i < sentence.length(); i++) {
            int currentChar = sentence.charAt(i);
            currentChar += 3;
            System.out.print((char)currentChar);
        }
    }
}
