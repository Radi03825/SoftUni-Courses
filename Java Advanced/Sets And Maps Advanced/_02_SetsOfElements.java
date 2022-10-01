import java.util.*;
import java.util.stream.Collectors;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        chargeSet(n, scanner, firstSet);
        chargeSet(m, scanner, secondSet);

        printRepeatingNumbers(firstSet, secondSet);
    }



    private static void printRepeatingNumbers(LinkedHashSet<Integer> firstSet, LinkedHashSet<Integer> secondSet) {
        List<String> numbersAsString = new ArrayList<>();
        for (Integer firstNumber : firstSet) {
            for (Integer secondNumber : secondSet) {
                if(firstNumber.equals(secondNumber)){
                    numbersAsString.add(firstNumber + "");
                }
            }
        }
        System.out.println(String.join(" ", numbersAsString));

    }

    private static void chargeSet(int n, Scanner scanner, LinkedHashSet<Integer> set) {
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(scanner.nextLine()));
        }
    }

    private static LinkedHashSet<String> readSet(String line){
        return Arrays.stream(line.split("\\s+"))
                .collect(Collectors.toCollection(LinkedHashSet::new));
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
