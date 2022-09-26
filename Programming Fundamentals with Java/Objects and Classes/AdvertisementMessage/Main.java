import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sentenceCount = Integer.parseInt(scanner.nextLine());

        Message message = new Message();

        for (int i = 0; i < sentenceCount; i++) {
            System.out.println(message.buildSentence());
        }
    }
}
