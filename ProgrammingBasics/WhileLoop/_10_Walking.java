import java.util.Scanner;

public class _10_Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goalSteps = 10000;
        while (true){
            String command = scanner.nextLine();
            if(command.equals("Going home")){
                int steps = Integer.parseInt(scanner.nextLine());
                goalSteps -= steps;
                break;
            }else {
                int steps = Integer.parseInt(command);
                goalSteps -= steps;
            }
            if(goalSteps <= 0){
                break;
            }
        }
        if(goalSteps > 0){
            System.out.printf("%d more steps to reach goal.", goalSteps);
        }else {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!", Math.abs(goalSteps));
        }
    }
}
