import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());

        int power = 0;

        for (int i = 0; i < text.size(); i++) {
            String currentChar = text.get(i);
            if(power > 0 && !currentChar.equals(">")){
                text.remove(i);
                power--;
                i--;
            }
            if(currentChar.equals(">")){
                power += Integer.parseInt(text.get(i + 1));
            }
        }
        System.out.println(String.join("", text));
    }
}
