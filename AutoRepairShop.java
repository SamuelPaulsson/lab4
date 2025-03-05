import java.util.*;

public class AutoRepairShop<T extends Vehicle> implements Loadable<T> {

    private final int maxCars;
    private final String shopName;
    private ArrayList<T> loadedCars;
    private double x;
    private double y;
    private final Class<T> type;

    public AutoRepairShop(Class<T> typ,double posX,double posY,int maxLoad, String shopName){
        maxCars = maxLoad;
        this.loadedCars = new ArrayList<>();
        this.shopName = shopName;
        this.x = posX;
        this.y = posY;
        this.type = typ;
    }

    public ArrayList<T> getLoadedCars() {
        return loadedCars;
    }

    public String getShopName() {
        return shopName;
    }

    public Class<T> getType(){return type;}

    public int getMaxCars() {
        return maxCars;
    }

    public double getX(){return this.x;}

    public double getY(){return this.y;}

    public void setX(double newX){x = newX;}

    public void setY(double newY){y = newY;}

    public T removeSpecific(T car) {
        if (loadedCars.contains(car)) {
            loadedCars.remove(car);
            return car;
        } else {  throw new NoSuchElementException("Car not in shop"); }

    }

    @Override
    public T offLoad() {
        if (loadedCars.isEmpty()) {
            throw new NoSuchElementException("No cars to offload");
        } else { return loadedCars.removeFirst(); }
    }

    @Override
    public void load(T car) {
        if (getLoadedCars().size() < getMaxCars()) {
             if (!getLoadedCars().contains(car)) {
                 loadedCars.add(car);
                 car.setCanMove(false);
             }
        }

        else {
             throw new IllegalArgumentException("Shop is full");
        }
    }
}
