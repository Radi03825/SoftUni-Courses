import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("[()]");

        int degrees = Integer.parseInt(input[1]);
        degrees = degrees % 360;

        List<String> words = new ArrayList<>();

        String command = scanner.nextLine();

        int longWordSize = 0;

        while (!command.equals("END")){
            words.add(command);
            if(command.length() > longWordSize){
                longWordSize = command.length();
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < words.size(); i++) {
            String current = words.get(i);

            if(current.length() < longWordSize){
                StringBuilder newCurrent = new StringBuilder(current);
                for (int j = 0; j < longWordSize - current.length(); j++) {
                    newCurrent.append(" ");
                }
                words.set(i, newCurrent.toString());
            }
        }

        String[][] matrix = new String[words.size()][longWordSize];

        for (int row = 0; row < matrix.length; row++) {
            String line = words.get(row);
            String[] elements = line.split("");

            matrix[row] = elements;
        }

        rotateMatrix(matrix, degrees, longWordSize);

    }

    private static void rotateMatrix(String[][] matrix, int degrees, int colLength) {
        if(degrees == 90){
            for (int cols = 0; cols < colLength; cols++) {
                for (int rows = matrix.length - 1; rows >= 0; rows--) {
                    System.out.print(matrix[rows][cols]);
                }
                System.out.println();
            }
        }else if(degrees == 180){
            for (int rows = matrix.length - 1; rows >= 0; rows--) {
                for (int cols = matrix[rows].length - 1; cols >= 0; cols--) {
                    System.out.print(matrix[rows][cols]);
                }
                System.out.println();
            }
        }else if(degrees == 270){
            for (int cols = colLength - 1; cols >= 0; cols--) {
                for (int rows = 0; rows < matrix.length; rows++) {
                    System.out.print(matrix[rows][cols]);
                }
                System.out.println();
            }
        }else {
            printMatrix(matrix);
        }

    }



    private static boolean checkForValid(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        return matrix.length > firstRow && matrix.length > secondRow && matrix[0].length > firstCol && matrix[0].length > secondCol;
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

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
