import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lights = scanner.nextLine().split("\\s+");
        int count = Integer.parseInt(scanner.nextLine());

        List<Light> lightList = new ArrayList<>();

        for (String light : lights) {
            Light l = new Light(Colors.valueOf(light));
            lightList.add(l);
        }

        for (int i = 0; i < count; i++) {
            for (Light light : lightList) {
                light.changeColors();
                System.out.print(light.getColor() + " ");
            }
            System.out.println();
        }
    }
}
