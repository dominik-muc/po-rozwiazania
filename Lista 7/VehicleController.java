import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    protected class SaveEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setProducent(view.getProducent());
            model.setModel(view.getModel());
            model.setAge(view.getAge());
            System.out.println(model.getProducent());
        }
    }
}
