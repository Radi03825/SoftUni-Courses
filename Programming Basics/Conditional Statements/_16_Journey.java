import java.util.Scanner;

public class _16_Journey {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String placeForHoliday = "";
        String placeForSleep = "";
        double price = 0;

        if(budget <= 100){
            placeForHoliday = "Bulgaria";
            if(season.equals("summer")){
                placeForSleep = "Camp";
                price = budget * 0.30;
            }else if(season.equals("winter")){
                placeForSleep = "Hotel";
                price = budget * 0.70;
            }
        }else if(budget > 100 && budget <= 1000){
            placeForHoliday = "Balkans";
            if(season.equals("summer")){
                placeForSleep = "Camp";
                price = budget * 0.40;
            }else if(season.equals("winter")){
                placeForSleep = "Hotel";
                price = budget * 0.80;
            }
        }else if(budget > 1000){
            placeForHoliday = "Europe";
            placeForSleep = "Hotel";
            price = budget * 0.90;
        }

        System.out.printf("Somewhere in %s", placeForHoliday);
        System.out.println();
        System.out.printf("%s - %.2f", placeForSleep, price);
    }
}
