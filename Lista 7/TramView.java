// Dominik Muc, 345952, Lista 7

import javax.swing.*;
import java.awt.*;

public class TramView extends VehicleView {
    protected JTextField maxPassengersField = new JTextField(10);
    protected JCheckBox isImmobilizedCheckBox = new JCheckBox();
    protected JTextField nextStopField = new JTextField(10);

    public TramView() {
        super("Tram Editor");
    }

    @Override
    public void init() {
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

        panel.add(new JLabel("Max Passengers:"));
        panel.add(maxPassengersField);

        panel.add(new JLabel("Is Immobilized:"));
        panel.add(isImmobilizedCheckBox);

        panel.add(new JLabel("Next Stop:"));
        panel.add(nextStopField);

        panel.add(saveButton);

        add(panel);
    }

    public int getMaxPassengers() {
        return Integer.parseInt(maxPassengersField.getText());
    }

    public boolean isImmobilized() {
        return isImmobilizedCheckBox.isSelected();
    }

    public String getNextStop() {
        return nextStopField.getText();
    }

    public void setMaxPassengers(int maxPassengers) {
        maxPassengersField.setText(String.valueOf(maxPassengers));
    }

    public void setImmobilized(boolean isImmobilized) {
        isImmobilizedCheckBox.setSelected(isImmobilized);
    }

    public void setNextStop(String nextStop) {
        nextStopField.setText(nextStop);
    }
}
