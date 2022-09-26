import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        while (!(firstDeck.size() == 0 || secondDeck.size() == 0)){
            if(firstDeck.get(0).equals(secondDeck.get(0))){
                firstDeck.remove(0);
                secondDeck.remove(0);
            }else if(firstDeck.get(0) > secondDeck.get(0)){
                int cardFromFirstDeck = firstDeck.get(0);
                int cardFromSecondDeck = secondDeck.get(0);
                firstDeck.remove(0);
                secondDeck.remove(0);

                firstDeck.add(cardFromFirstDeck);
                firstDeck.add(cardFromSecondDeck);
            }else if(secondDeck.get(0) > firstDeck.get(0)){
                int cardFromSecondDeck = secondDeck.get(0);
                int cardFromFirstDeck = firstDeck.get(0);
                secondDeck.remove(0);
                firstDeck.remove(0);

                secondDeck.add(cardFromSecondDeck);
                secondDeck.add(cardFromFirstDeck);
            }
        }

        String winner = "";
        if(firstDeck.size() == 0){
            winner = "Second";
        }else if(secondDeck.size() == 0){
            winner = "First";
        }

        int sum = 0;
        if(winner.equals("First")){
            for (int i = 0; i < firstDeck.size(); i++) {
                sum += firstDeck.get(i);
            }
        }else if(winner.equals("Second")){
            for (int i = 0; i < secondDeck.size(); i++) {
                sum += secondDeck.get(i);
            }
        }

        System.out.printf("%s player wins! Sum: %d%n", winner, sum);
    }
}
