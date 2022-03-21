package vehicle;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage){
        super("Ford", "Frivolous", startingMileage, 23.6, 30);
    }
    /** Defaults mileage to 0. */
    public FordFrivolous(){
        super("Ford", "Frivolous", 0, 23.6, 20);
    }

    @Override
    public void fly(double miles){
        if(miles<0 || miles>getRemainingRange()){
            throw new IllegalArgumentException();
        }
        decreaseFuelLevel(miles * 3);
    }

    @Override
    public boolean canFly(double miles){
        if (miles<0){
            throw new IllegalArgumentException(); 
        }
        if (miles < getFuelLevel()){
            return true; 
        }
        return false; 
    }
    
    @Override
    public void driveAutonomously(double miles){
        if(miles<0 || miles>getRemainingRange()){ //can't drive neg or too many miles
            throw new IllegalArgumentException();
        }

        decreaseFuelLevel(miles * 2);
        addMileage(miles); 
    }
}