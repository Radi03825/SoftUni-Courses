import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String thirdToken = tokens[2];
            String name = tokens[0];
            if(thirdToken.equals("not")){
                if(names.contains(name)){
                    names.remove(name);
                }else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }else {
                if(names.contains(name)){
                    System.out.printf("%s is already in the list!%n", name);
                }else {
                    names.add(name);
                }
            }
        }

        names.forEach(e -> System.out.println(e));

    }
}
