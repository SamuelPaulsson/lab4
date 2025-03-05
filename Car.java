import java.awt.*;

public abstract class Car implements Vehicle {

    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    protected int direction;// 0 = north, 1 = east, 2 = south, 3 = west
    protected boolean canMove = true;



    public Car(double xPos, double yPos, int nrDoors, double enginePower, Color color, String modelName) {
            this.nrDoors = nrDoors;
            if (enginePower <= 0){
                throw new IllegalArgumentException("Engine power must be positive");//Tillåter ej
            }
            this.enginePower = enginePower;
            this.color = color;
            this.modelName = modelName;
            this.x = xPos;
            this.y = yPos;
            this.direction = 1;
            stopEngine();
    }

    public double getX() {
        return x;
    }

    public void setX(int numb) { x =  numb; }

    public void setY(int numb) { y =  numb; }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public String getModell() {
        return modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public boolean getCanMove(){return canMove;}

    public void setCanMove(boolean argument){canMove = argument;}

    public void startEngine() {
        if(currentSpeed== 0){currentSpeed = 0.1;}
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
    public abstract double speedFactor();


    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && getCurrentSpeed() > 0) {
            incrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Gas måste vara mellan 0 och 1 och motorn skall vara igång!");
        }
    }


    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Brake måste vara mellan 0 och 1!");
        }
    }

    @Override
    public void move() {
        if(getCanMove()) {
            switch (direction) {
                case 0:
                    y += getCurrentSpeed();
                    break;
                case 1:
                    x += getCurrentSpeed();
                    break;
                case 2:
                    y -= getCurrentSpeed();
                    break;
                case 3:
                    x -= getCurrentSpeed();

            }
        }
    }

    @Override
    public void turnLeft(){
        switch (direction) {
            case 0:
                direction = 3;
                break;
            case 1:
                direction = 0;
                break;
            case 2:
                direction = 1;
                break;
            case 3:
                direction = 2;
                break;
        }
    }

    @Override
    public void turnRight(){
        switch (direction) {
            case 0:
                direction = 1;
                break;
            case 1:
                direction = 2;
                break;
            case 2:
                direction = 3;
                break;
            case 3:
                direction = 0;
                break;
        }
    }
}

