public class Car extends Vehicle {
    private static final long serialVersionUID = 2L;

    protected int doors;
    protected int enginePower;
    protected EngineType engineType;

    public Car(Vehicle base, int doors, int enginePower, EngineType engineType) {
        super(base);
        this.doors = doors;
        this.enginePower = enginePower;
        this.engineType = engineType;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}