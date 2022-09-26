import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] tokens = command.split("\\s+");

            String typeWithCapitalLetter = tokens[0].substring(0, 1).toUpperCase() + tokens[0].substring(1);

            Vehicle vehicle = new Vehicle(typeWithCapitalLetter, tokens[1], tokens[2], Integer.parseInt(tokens[3]));
            vehicles.add(vehicle);

            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("Close the Catalogue")){
            for (Vehicle model: vehicles) {
                if(command.equals(model.getModel())){
                    System.out.printf("Type: %s%n", model.getTypeOfVehicle());
                    System.out.printf("Model: %s%n", model.getModel());
                    System.out.printf("Color: %s%n", model.getColor());
                    System.out.printf("Horsepower: %s%n", model.getHorsepower());
                }
            }
            command = scanner.nextLine();
        }

        double carSum = 0;
        int carCount = 0;

        double truckSum = 0;
        int truckCount = 0;

        for (Vehicle vehicle: vehicles) {
            if(vehicle.getTypeOfVehicle().equals("Car")){
                carSum += vehicle.getHorsepower();
                carCount++;
            }else if(vehicle.getTypeOfVehicle().equals("Truck")){
                truckSum += vehicle.getHorsepower();
                truckCount++;
            }
        }

        double carAverage = 0.00;
        double truckAverage = 0.00;

        if(carSum > 0){
            carAverage = carSum / carCount;
        }
        if(truckSum > 0){
            truckAverage = truckSum / truckCount;
        }

        System.out.printf("Cars have average horsepower of: %.2f.%n", carAverage);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", truckAverage);

    }
}
