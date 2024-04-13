public class Tram extends Vehicle {
    private static final long serialVersionUID = 3L;

    protected int maxPassengers;
    protected boolean isImmobilized;
    protected String nextStop;

    public Tram(Vehicle base, int maxPassengers, boolean isImmobilized, String nextStop) {
        super(base);
        this.maxPassengers = maxPassengers;
        this.isImmobilized = isImmobilized;
        this.nextStop = nextStop;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public boolean isImmobilized() {
        return isImmobilized;
    }

    public void setImmobilized(boolean immobilized) {
        isImmobilized = immobilized;
    }

    public String getNextStop() {
        return nextStop;
    }

    public void setNextStop(String nextStop) {
        this.nextStop = nextStop;
    }
}
