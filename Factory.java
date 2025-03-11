import java.util.Random;

public class Factory {

    private static Random random = new Random();
    public enum VehicleType {
        Saab95, Volvo240, Scania
    };

    public static CarObject addRandomCar(){
        int choice = random.nextInt(VehicleType.values().length);
        VehicleType ty = VehicleType.values()[choice];
        return addSpecificCar(ty);

    }
    public static CarObject addSpecificCar(VehicleType vehicleType){
        return switch (vehicleType) {
            case Saab95 -> createSaab95();
            case Volvo240 -> createVolvo240();
            case Scania -> createScania();
            // default:
            //   throw new IllegalArgumentException("Unknown car type: " + vehicleType);
        };

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
    public static <T extends Vehicle> AutoObject<T> createAutoShop(Class<T> type,String name) {
        AutoRepairShop<T> autoShop = new AutoRepairShop<>(type,400,30,10,name);
        return new AutoObject<>(autoShop);
    }
}
