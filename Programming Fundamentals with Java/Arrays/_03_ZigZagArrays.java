import java.util.Scanner;

public class _03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        boolean zigZag = true;
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");
            if(zigZag){
                firstArray[i] = Integer.parseInt(elements[0]);
                secondArray[i] = Integer.parseInt(elements[1]);
                zigZag = false;
            }else {
                firstArray[i] = Integer.parseInt(elements[1]);
                secondArray[i] = Integer.parseInt(elements[0]);
                zigZag = true;
            }
        }

        for (int i : firstArray) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i : secondArray) {
            System.out.print(i + " ");
        }


    }
}
