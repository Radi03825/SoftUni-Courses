public class Car {
    String model;
    String engineSpeed;
    int enginePower;
    String cargoWeight;
    String cargoType;
    Tire tires;

    public Car(String model, String engineSpeed, int enginePower, String cargoWeight, String cargoType, Tire tires) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tires = tires;
    }
}
