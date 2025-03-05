import java.util.Random;

public class Factory {

    private static Random random = new Random();
    public enum VehicleType {
        Saab95, Volvo240, Scania
    };

    public static CarObject addRandomCar(){
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
    public static CarObject addSpecificCar(VehicleType vehicleType){
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

    public static CarObject createSaab95(){
        Saab95 saab =  new Saab95();
        return new CarObject(saab);
    }
    public static CarObject createVolvo240(){
        Volvo240 volvo = new Volvo240();
        return new CarObject(volvo);
    }
    public static CarObject createScania(){
        Scania scania = new Scania();
        return new CarObject(scania);
    }
    public static <T extends Vehicle> AutoRepairShop<T> createAutoShop(Class<T> type,String name) {
        return new AutoRepairShop<>(type,400,30,10,name);
    }
}
