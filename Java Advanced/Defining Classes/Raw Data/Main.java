import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            String engineSpeed = input[1];
            int enginePower = Integer.parseInt(input[2]);
            String cargoWeight = input[3];
            String cargoType = input[4];

            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tire);

            cars.add(car);
        }

        String command = scanner.nextLine();

        if(command.equals("fragile")) {
            cars.stream().filter(c -> c.cargoType.equals("fragile")).filter(v -> v.tires.getAveragePressure() < 1).forEach(e -> System.out.println(e.model));
        }else {
            cars.stream().filter(c -> c.cargoType.equals("flamable")).filter(v -> v.enginePower > 250).forEach(e -> System.out.println(e.model));
        }
    }
}
