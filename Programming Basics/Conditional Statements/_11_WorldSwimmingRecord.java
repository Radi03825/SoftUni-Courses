import java.util.Scanner;

public class _11_WorldSwimmingRecord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double range = Double.parseDouble(scanner.nextLine());
        double secondsForOneMeter = Double.parseDouble(scanner.nextLine());

        double time = (Math.floor(range / 15) * 12.5) + (range * secondsForOneMeter);

        if(time < record){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", time);
        }else {
            double needTime = time - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", needTime);
        }
    }
}
