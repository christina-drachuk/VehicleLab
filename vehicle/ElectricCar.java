package VehicleLab.vehicle;

public abstract class ElectricCar extends Car {
    private double milesOnMaxCharge;
    private double remainingCharge;
    /** Note: Car begins with a full charge (and thus range).
    @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
    public ElectricCar(String make, String model, double startingMileage,
    double milesOnMaxCharge) {
        this.make = make;
        this.model = model;
        this.startingMileage = startingMileage;
        if (milesOnMaxCharge <= 0) {
            throw new IllegalArgumentException();
        }
        this.remainingCharge = milesOnMaxCharge;
        this.milesOnMaxCharge = milesOnMaxCharge;
    }

    /** Defaults mileage to 0.
    @throws IllegalArgumentException if milesOnMaxCharge is nonpositive.*/
    public ElectricCar (String make, String model, double
    milesOnMaxCharge) {
        this(make, model, 0, milesOnMaxCharge);
    }

    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative.
    @throws IllegalArgumentException if miles is too high given the
    current charge.*/
    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        if (miles > this.remainingCharge) {
            throw new IllegalArgumentException()
        }

        addMileage(miles);
        decreaseCharge(miles);
    }

    /** Returns how many more miles the car can currently go without
    recharging. */
    public double getRemainingRange() {
        return remainingCharge;
    }

    /** Returns how many miles the car could go on a full charge. */
    public double getMaxRange() {
        return milesOnMaxCharge;
    }

    /** Recharges the car to max range capability. */
    public void recharge() {
        this.remainingCharge = milesOnMaxCharge;
    }

    /** Decreases the amount of energy in the battery based by the number
    of miles passed as an argument. */
    protected void decreaseCharge(double miles) {
        this.remainingCharge -= miles;
    }
}