package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage){
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }
    /** Defaults mileage to 0. */
    public FordFrivolous(){
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    @Override
    public void fly(double miles){
        if(miles<0 || miles>getRemainingRange() / 3){
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(miles * 3);
    }

    @Override
    public boolean canFly(double miles){
        if (miles<0){
            throw new IllegalArgumentException(); 
        }
        if (miles <= getRemainingRange() / 3){
            return true; 
        }

        return false; 
    }
    
    @Override
    public void driveAutonomously(double miles){
        if (miles < 0) {
            throw new IllegalArgumentException();
        }

        if (miles*2 > getRemainingRange()) {
            addMileage(getRemainingRange()/2);
            decreaseFuelLevel(getRemainingRange());
        }
        else {
            addMileage(miles);
            decreaseFuelLevel(miles*2);
        }

    }
}