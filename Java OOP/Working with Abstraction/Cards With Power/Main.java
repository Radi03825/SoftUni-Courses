import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        System.out.println(String.format("Card name: %S of %s; Card power: %d", cardRank, cardSuit, CardRank.valueOf(cardRank).getValue() + CardSuit.valueOf(cardSuit).getValue()));

    }
}
