import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _02_MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scanner.nextLine();

        while (!resource.equals("stop")){
            int count = Integer.parseInt(scanner.nextLine());
            if(resources.containsKey(resource)){
                int currentCount = resources.get(resource);
                count += currentCount;
            }
            resources.put(resource, count);

            resource = scanner.nextLine();
        }


        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
