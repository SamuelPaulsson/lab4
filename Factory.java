import java.util.Random;

public class Factory {

    private Random random = new Random();
    public enum VehicleType {
        Saab95, Volvo240, Scania
    };

    public Vehicle addRandomCar(){
        int choice = random.nextInt(3);

        switch (choice) {
            case 0:
                return createSaab95();
            case 1:
                return createVolvo240();
            case 2:
                return createScania();
            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }
    public Vehicle addSpecificCar(VehicleType vehicleType){
        switch (vehicleType) {
            case Saab95:
                return createSaab95();
            case Volvo240:
                return createVolvo240();
            case Scania:
                return createScania();
            default:
                throw new IllegalArgumentException("Unknown car type: " + vehicleType);
        }

    }

    public Saab95 createSaab95(){
        return new Saab95();
    }
    public Volvo240 createVolvo240(){
        return new Volvo240();
    }
    public Scania createScania(){
        return new Scania();
    }
    public <T extends Vehicle> AutoRepairShop<T> createAutoShop(Class<T> type,String name) {
        return new AutoRepairShop<>(type,400,30,10,name);
    }
}
