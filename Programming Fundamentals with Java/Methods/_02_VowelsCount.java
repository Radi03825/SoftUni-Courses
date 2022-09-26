import java.util.Scanner;

public class _02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = sumVocal(scanner.nextLine());
        System.out.println(count);
    }

    private static int sumVocal(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if(currentChar == 'a' || currentChar == 'o' || currentChar == 'u' || currentChar == 'i' || currentChar == 'e' || currentChar == 'A' || currentChar == 'O' || currentChar == 'U' || currentChar == 'I' || currentChar == 'E'){
                count++;
            }
        }
        return count;
    }

}
