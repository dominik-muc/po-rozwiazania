public class Car extends Vehicle{
    protected int doors;
    protected int enginePower;
    protected EngineType engineType;

    public Car(Vehicle base, int doors, int enginePower, EngineType engineType){
        super(base);
        this.doors = doors;
        this.enginePower = enginePower;
        this.engineType = engineType;
    }
}
