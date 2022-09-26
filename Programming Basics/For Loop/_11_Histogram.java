import java.util.Scanner;

public class _11_Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        double numberCount = 0;
        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 1; i <= n; i++){
            int number = Integer.parseInt(scanner.nextLine());
            if(number >= 1 && number < 200){
                p1++;
            }else if(number >= 200 && number < 400){
                p2++;
            }else if(number >= 400 && number < 600){
                p3++;
            }else if(number >= 600 && number < 800){
                p4++;
            }else if(number >= 800 && number <= 1000){
                p5++;
            }
            numberCount++;
        }

        System.out.printf("%.2f", (p1 / numberCount) * 100);
        System.out.print("%");
        System.out.println();
        System.out.printf("%.2f", (p2 / numberCount) * 100);
        System.out.print("%");
        System.out.println();
        System.out.printf("%.2f", (p3 / numberCount) * 100);
        System.out.print("%");
        System.out.println();
        System.out.printf("%.2f", (p4 / numberCount) * 100);
        System.out.print("%");
        System.out.println();
        System.out.printf("%.2f", (p5 / numberCount) * 100);
        System.out.print("%");
    }
}
