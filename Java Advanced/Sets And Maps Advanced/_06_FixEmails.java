import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("stop")){
            String email = scanner.nextLine();
            String[] emailTokens = email.split("\\.");

            String lastPart = emailTokens[emailTokens.length - 1].toLowerCase();

            if(!(lastPart.equals("us") || lastPart.equals("uk") || lastPart.equals("com"))){
                emails.put(command, email);
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
