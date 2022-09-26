import java.util.Scanner;

public class _07_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        while (!word.equals("END")){
            checkWord(word);
            word = scanner.nextLine();
        }

    }

    private static void checkWord(String word) {
        boolean isEqual = true;
        int c = word.length() - 1;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(c)){
                isEqual = false;
            }
            c--;
        }
        if(isEqual){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
