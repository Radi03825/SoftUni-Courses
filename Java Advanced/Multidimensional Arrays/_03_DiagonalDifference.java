import java.util.Arrays;
import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];


        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            matrix[row] = line;
        }


        int firstDiagonal = sumFirstDiagonal(matrix);
        int secondDiagonal = sumSecondDiagonal(matrix);

        int difference = Math.abs(firstDiagonal - secondDiagonal);

        System.out.println(difference);

    }



    private static int sumSecondDiagonal(int[][] matrix) {
        int row = 0;
        int col = matrix.length - 1;

        int sum = 0;

        while (!(row >= matrix.length || col < 0)){
            sum += matrix[row][col];

            row++;
            col--;
        }
        return sum;
    }

    private static int sumFirstDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
}
