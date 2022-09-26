import java.util.Scanner;

public class _05_MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallestNumber = Integer.MAX_VALUE;
        boolean stop = false;

        while (true){
            String command = scanner.nextLine();
            if(command.equals("Stop")){
                stop = true;
                System.out.println(smallestNumber);
                break;
            }else {
                int number = Integer.parseInt(command);
                if(number < smallestNumber){
                    smallestNumber = number;
                }
            }
        }

        if(!stop) {
            System.out.println(smallestNumber);
        }
    }
}
