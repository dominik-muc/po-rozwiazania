import javax.swing.*;

public class MVCDemo {
    public static void main(String[] args) {
        Vehicle model = new Vehicle("Toyota", "Corolla", 5);

            VehicleView view = new VehicleView();
            new VehicleController(model, view);
            view.setVisible(true);

        
    }
}
