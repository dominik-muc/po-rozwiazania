import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CarController extends VehicleController{
    protected Car model;
    protected CarView view;

    public CarController(Car model, CarView view){
        super(model, view);
    }

    @Override
    public void initView() {
        super.initView();
        view.setDoors(model.getDoors());
        view.setEnginePower(model.getEnginePower());
        view.setEngineType(model.getEngineType());
    }
    
    @Override
    public void updateModel(){
        super.updateModel();
        model.setDoors(view.getDoors());
        model.setEnginePower(view.getEnginePower());
        model.setEngineType(view.getEngineType());
    }

    class SaveEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                updateModel();
                System.err.println("test");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Insert proper values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
}

