import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VehicleController {
    private Vehicle model;
    private VehicleView view;

    public VehicleController(Vehicle model, VehicleView view) {
        this.model = model;
        this.view = view;
        this.view.addSaveButtonListener(new SaveEventListener());
        initView();
    }

    public void initView() {
        view.setProducent(model.getProducent());
        view.setModel(model.getModel());
        view.setAge(model.getAge());
    }

    public void updateModel(){
        model.setProducent(view.getProducent());
        model.setModel(view.getModel());
        model.setAge(view.getAge());
    }

    class SaveEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                updateModel();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Insert proper values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
}
