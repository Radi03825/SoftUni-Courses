import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String letter = input[1];

        int[][] matrix = new int[n][n];

        int counter = 1;

        for (int i = 0; i < matrix.length; i++) {
            if(letter.equals("B") && i % 2 != 0){
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }else {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
