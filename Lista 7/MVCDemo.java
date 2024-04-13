import javax.swing.*;

public class MVCDemo {
    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        /* Vehicle model = new Vehicle("Toyota", "Corolla", 5);
        VehicleView view = new VehicleView("Vehicle view");
        new VehicleController(model, view);
        view.setVisible(true); */

        Car model = new Car(new Vehicle("Toyota", "Corolla", 5), 3, 120, EngineType.GASOLINE);
        CarView view = new CarView();
        new CarController(model, view);
        view.init();
        view.setVisible(true);
    }
}
