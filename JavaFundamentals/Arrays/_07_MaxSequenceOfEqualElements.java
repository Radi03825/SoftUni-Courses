import java.util.Arrays;
import java.util.Scanner;

public class _07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        int biggestSequence = 0;
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            int currentSequence = 1;
            for (int j = i + 1; j < array.length; j++) {
                if(array[i] != array[j]){
                    break;
                }else {
                    currentSequence++;
                }
            }
            if(currentSequence > biggestSequence){
                biggestSequence = currentSequence;
                number = array[i];
            }

        }

        for (int i = 0; i < biggestSequence; i++) {
            System.out.print(number + " ");
        }

    }
}
