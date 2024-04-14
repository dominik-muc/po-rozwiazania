// Dominik Muc, 345952, Lista 7

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class VehicleController {
    private Vehicle model;
    private VehicleView view;

    public VehicleController(Vehicle model, VehicleView view) {
        this.model = model;
        this.view = view;
        this.view.addSaveButtonListener(new SaveEventListener());
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
        public void actionPerformed(ActionEvent event) {
            try {
                updateModel();
                
                try(FileOutputStream fileOut = new FileOutputStream(Editor.path);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
             
                    objectOut.writeObject(model);
                } 
                catch (IOException e) {
                    System.out.println("An error occurred while writing the object to file.");
                    e.printStackTrace();
                    return;
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Insert proper values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
