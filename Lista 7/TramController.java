// Dominik Muc, 345952, Lista 7

public class TramController extends VehicleController {
    protected Tram tramModel;
    protected TramView tramView;

    public TramController(Tram model, TramView view) {
        super(model, view);
        this.tramModel = model;
        this.tramView = view;
    }

    @Override
    public void initView() {
        super.initView();
        tramView.setMaxPassengers(tramModel.getMaxPassengers());
        tramView.setImmobilized(tramModel.isImmobilized());
        tramView.setNextStop(tramModel.getNextStop());
    }
    
    @Override
    public void updateModel() {
        super.updateModel();
        tramModel.setMaxPassengers(tramView.getMaxPassengers());
        tramModel.setImmobilized(tramView.isImmobilized());
        tramModel.setNextStop(tramView.getNextStop());
    }
}
