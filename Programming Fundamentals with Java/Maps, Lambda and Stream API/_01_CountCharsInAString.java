import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> letters = new LinkedHashMap<>();

        String[] letter = scanner.nextLine().split("");

        for (String s : letter) {
            if(s.equals(" ")){
                continue;
            }
            if(letters.containsKey(s)){
                int count = letters.get(s);
                count++;
                letters.put(s, count);
            }else {
                letters.put(s, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : letters.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
