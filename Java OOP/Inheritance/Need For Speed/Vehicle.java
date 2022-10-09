public class Vehicle {
    public final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;
    private double fuel;
    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        this.fuel = fuel;
        this.horsePower = horsePower;
        fuelConsumption = DEFAULT_FUEL_CONSUMPTION;
    }


    //The drive method should have a functionality to reduce the fuel based on the travelled
    //kilometers and fuel consumption. Keep in mind that you can drive the vehicle only if you have
    //enough fuel to finish the driving.
    public void drive(double kilometers) {
        double totalFuelConsumption = kilometers * fuelConsumption;

        if(totalFuelConsumption <= fuel) {
            fuel -= totalFuelConsumption;
        }
    }

    public static double getDefaultFuelConsumption() {
        return DEFAULT_FUEL_CONSUMPTION;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
