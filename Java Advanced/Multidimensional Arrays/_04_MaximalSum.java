import java.util.Arrays;
import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            matrix[row] = line;
        }

        int biggestSum = 0;

        int indexOfRow = -1;
        int indexOfCol = -1;

        for (int i = 0; i <= matrix.length - 3; i++) {
            for (int j = 0; j <= matrix[i].length - 3; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] + matrix[i + 1][j] + matrix[i + 2][j]
                        + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if(sum > biggestSum){
                    biggestSum = sum;
                    indexOfRow = i;
                    indexOfCol = j;
                }
            }
        }

        System.out.println("Sum = " + biggestSum);

        for (int i = indexOfRow; i < indexOfRow + 3; i++) {
            for (int j = indexOfCol; j < indexOfCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }



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
