import java.io.Serializable;

public class Vehicle implements Serializable{
    private static final long serialVersionUID = 1L;

    protected String producent;
    protected String model;
    protected int age;

    public Vehicle(String producent, String model, int age) {
        this.producent = producent;
        this.model = model;
        this.age = age;
    }

    public Vehicle(Vehicle other){
        this.producent = other.getProducent();
        this.model = other.getModel();
        this.age = other.getAge();
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
