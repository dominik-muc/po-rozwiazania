import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class CarController extends VehicleController{
    protected Car carModel;
    protected CarView carView;

    public CarController(Car model, CarView view){
        super(model, view);
        this.carModel = model;
        this.carView = view;
    }

    @Override
    public void initView() {
        super.initView();
        carView.setDoors(carModel.getDoors());
        carView.setEnginePower(carModel.getEnginePower());
        carView.setEngineType(carModel.getEngineType());
    }
    
    @Override
    public void updateModel(){
        super.updateModel();
        carModel.setDoors(carView.getDoors());
        carModel.setEnginePower(carView.getEnginePower());
        carModel.setEngineType(carView.getEngineType());
        System.err.println(carModel.enginePower);
    }
}

