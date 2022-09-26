import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            String command = tokens[0];
            String name = tokens[1];

            if(command.equals("register")){
                String number = tokens[2];
                if(parking.containsKey(name)){
                    System.out.printf("ERROR: already registered with plate number %s%n", parking.get(name));
                }else {
                    parking.put(name, number);
                    System.out.printf("%s registered %s successfully%n", name, number);
                }
            }else if(command.equals("unregister")){
                if(parking.containsKey(name)){
                    parking.remove(name);
                    System.out.printf("%s unregistered successfully%n", name);
                }else {
                    System.out.printf("ERROR: user %s not found%n", name);
                }
            }
        }


        for (Map.Entry<String, String> entry : parking.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
