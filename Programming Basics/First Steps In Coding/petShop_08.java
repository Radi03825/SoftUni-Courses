import java.util.Scanner;

public class petShop_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogs = Integer.parseInt(scanner.nextLine());
        int otherPets = Integer.parseInt(scanner.nextLine());
        double totalPrice = dogs * 2.50 + otherPets * 4;
        System.out.println(totalPrice + " lv.");


    }
}
