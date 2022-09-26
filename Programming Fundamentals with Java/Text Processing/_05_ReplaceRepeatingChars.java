import java.util.Scanner;

public class _05_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        char ch = text.charAt(0);
        int count = 1;
        String currentText = "";
        int firstIndex = 0;
        int forIndex = 0;

        for (int i = 1; i < text.length(); i++) {
            forIndex = i;
            if(text.charAt(i) == ch){
                count++;
            }else {
                if(count > 1){
                    firstIndex = i - count;
                    currentText = text.substring(firstIndex, i);
                    text = text.replaceFirst(currentText, String.valueOf(ch));
                }else {
                    firstIndex++;
                }

                i = firstIndex;
                count = 0;
                ch = text.charAt(i + 1);
            }
        }
        if(count > 1){
            firstIndex = forIndex - count;
            currentText = text.substring(firstIndex + 1);
            text = text.replaceFirst(currentText, String.valueOf(ch));
        }
        System.out.println(text);
    }
}
