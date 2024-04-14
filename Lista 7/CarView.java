// Dominik Muc, 345952, Lista 7

import javax.swing.*;
import java.awt.*;

public class CarView extends VehicleView{
    protected JTextField doorsField = new JTextField(10);
    protected JTextField enginePowerField = new JTextField(10);
    protected JComboBox<EngineType> engineTypeBox = new JComboBox<EngineType>(EngineType.values());

    public CarView() {
        super("Car editor");
    }
    @Override
    public void init(){
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2));
        panel.add(new JLabel("Producent:"));
        panel.add(producentField);

        panel.add(new JLabel("Model:"));
        panel.add(modelField);

        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        panel.add(new JLabel("Doors:"));
        panel.add(doorsField);

        panel.add(new JLabel("Engine power:"));
        panel.add(enginePowerField);

        panel.add(new JLabel("Engine type:"));
        panel.add(engineTypeBox);

        panel.add(saveButton);

        add(panel);
    }

    public int getDoors() {
        return Integer.parseInt(doorsField.getText());
    }

    public int getEnginePower() {
        return Integer.parseInt(enginePowerField.getText());
    }

    public EngineType getEngineType() {
        return (EngineType) engineTypeBox.getSelectedItem();
    }

    public void setDoors(int doors) {
        doorsField.setText(String.valueOf(doors));
    }

    public void setEnginePower(int enginePower) {
        enginePowerField.setText(String.valueOf(enginePower));
    }

    public void setEngineType(EngineType engineType) {
        engineTypeBox.setSelectedItem(engineType);
    }
}
