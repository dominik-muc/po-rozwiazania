import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VehicleView extends JFrame {
    protected JTextField producentField = new JTextField(10);
    protected JTextField modelField = new JTextField(10);
    protected JTextField ageField = new JTextField(10);
    protected JButton saveButton = new JButton("Save");

    public VehicleView(String title) {
        super(title);
    }

    public void init(){
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Producent:"));
        panel.add(producentField);
        panel.add(new JLabel("Model:"));
        panel.add(modelField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(saveButton);

        add(panel);
    }

    public String getProducent() {
        return producentField.getText();
    }

    public String getModel() {
        return modelField.getText();
    }

    public int getAge() {
        return Integer.parseInt(ageField.getText());
    }

    public void setProducent(String producent) {
        producentField.setText(producent);
    }

    public void setModel(String model) {
        modelField.setText(model);
    }

    public void setAge(int age) {
        ageField.setText(String.valueOf(age));
    }

    public void addSaveButtonListener(ActionListener listenForSaveButton) {
        saveButton.addActionListener(listenForSaveButton);
    }
}
