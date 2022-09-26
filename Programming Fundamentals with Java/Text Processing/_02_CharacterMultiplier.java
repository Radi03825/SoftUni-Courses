import java.util.Scanner;

public class _02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        int firstWordLength = words[0].length();
        int secondWordLength = words[1].length();

        int index = 0;
        int totalSum = 0;

        while (firstWordLength > index && secondWordLength > index){

            int charFromFirstWord = words[0].charAt(index);
            int charFromSecondWord = words[1].charAt(index);
            int multiplySum = charFromFirstWord * charFromSecondWord;
            totalSum += multiplySum;
            index++;
        }
        if(index >= firstWordLength){
            for (int i = index; i < secondWordLength; i++) {
                totalSum += words[1].charAt(i);
            }
        }else if(index >= secondWordLength){
            for (int i = index; i < firstWordLength; i++) {
                totalSum += words[0].charAt(i);
            }
        }

        System.out.println(totalSum);

    }
}
