import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        while (n-- > 0){
            Double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
        }


        System.out.println(box.countOfGreaterValues(Double.parseDouble(scanner.nextLine())));
    }
}
