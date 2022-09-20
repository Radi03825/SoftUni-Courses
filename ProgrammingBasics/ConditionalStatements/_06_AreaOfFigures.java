import java.util.Scanner;

public class _06_AreaOfFigures {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        double space = 0;

        if(figure.equals("square")){
            double a = Double.parseDouble(scanner.nextLine());
            space = a * a;
        }else if(figure.equals("rectangle")){
            double a = Double.parseDouble(scanner.nextLine());
            double b = Double.parseDouble(scanner.nextLine());
            space = a * b;
        }else if(figure.equals("circle")){
            double radius = Double.parseDouble(scanner.nextLine());
            space = Math.PI * radius * radius;
        }else if(figure.equals("triangle")){
            double a = Double.parseDouble(scanner.nextLine());
            double h = Double.parseDouble(scanner.nextLine());
            space = (a * h) / 2;
        }
        System.out.printf("%.3f", space);



    }
}
