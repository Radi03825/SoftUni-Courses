import java.util.Scanner;

public class _08_BonusScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        double number = n;

        if(n <= 100){
            number += 5;
        }else if(n > 100 && n < 1000){
            number *= 1.20;
        }else if(n >= 1000){
            number *= 1.10;
        }
        if (n % 2 == 0){
            number += 1;
        }
        if(n % 10 == 5){
            number += 2;
        }
        double bonus = number - n;
        System.out.printf("%.1f", bonus);
        System.out.println();
        System.out.printf("%.1f", number);


    }
}
