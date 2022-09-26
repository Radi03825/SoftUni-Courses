import java.util.Scanner;

public class _06_BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double biggestKeg = 0;
        String biggestModel = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double pi = Math.PI;
            double formula = pi * radius * radius * height;

            if(formula > biggestKeg){
                biggestKeg = formula;
                biggestModel = model;
            }

        }

        System.out.println(biggestModel);
    }
}
