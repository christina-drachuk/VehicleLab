package VehicleLab;
//i don't acutually know if this works rn...i'll check it later

public class HondaAccordian extends GasPoweredCar{
    /** modelYear specifies the year this car was made. Honda cares about
    that stuff. All Honda Accordian models have 14.5 gallon tanks and
    33.2 MPG. */
    public HondaAccordian(double startingMileage, int modelYear){
        super("Honda", "Accordian", startingMileage, 33.2, 14.5);
        this.modelYear = modelYear;
    }
    /** Defaults mileage to 0. */
    public HondaAccordian(int year){
        super("Honda","Accordian", 33.2, 14.5);
        this.modelYear = year;
    }
    /** Prints out the model year, make and model, and mileage.
    Ex: "2019 Honda Accordian (<mileage> mi)"
    Coding tip: Write this method to re-use the behavior of the
    superclass toString. Don’t copy-and-paste the same code here. */
    public String toString(){
        return modelYear + " " + super.toString();
    }
}