import java.util.Random;

public class Factory {

    private Random random = new Random();
    public enum CarType {
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
    public Vehicle addSpecificCar(CarType carType){
        switch (carType) {
            case Saab95:
                return createSaab95();
            case Volvo240:
                return createVolvo240();
            case Scania:
                return createScania();
            default:
                throw new IllegalArgumentException("Unknown car type: " + carType);
        }

    }

    public Saab95 createSaab95(){
        return new Saab95();
    }
    public Volvo240 createVolvo240(){
        return new Volvo240();
    }
    public Scania createScania (){
        return new Scania();
    }

}
