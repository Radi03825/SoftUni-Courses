import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            int count = 0;
            if(symbols.containsKey(current)) {
                count = symbols.get(current);
            }
            symbols.put(current, count + 1);

        }

        symbols.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " time/s"));
    }
}
