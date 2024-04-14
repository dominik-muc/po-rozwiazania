// Dominik Muc, 345952, Lista 7

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Editor {
    static public String path;

    public static void printUsage(){
        System.err.println("Usage: java Editor <filepath> <object type>");
        System.err.println("Supported object types: Vehicle, Car, Tram");
    }

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        if(args.length != 2){
            printUsage();
            return;
        }

        path = args[0];

        Vehicle model;
        VehicleView view;
        VehicleController controller;

        try(FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)){
            
            model = (Vehicle) objectIn.readObject();
        } 
        catch (FileNotFoundException _) {
            switch(args[1]){
                case "Vehicle":
                    model = new Vehicle("Producent", "Model", 0);
                    break;
                case "Car":
                    model = new Car(new Vehicle("Producent", "Model", 0), 0, 0, EngineType.GASOLINE);
                    break;
                case "Tram":
                    model = new Tram(new Vehicle("Producent", "Model", 0), 100, true, "Most Grunwaldzki");
                    break;
                default:
                    printUsage();
                    return;
            }
            try(FileOutputStream fileOut = new FileOutputStream(path);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
             
                objectOut.writeObject(model);

            } 
            catch(Exception e){
                System.err.println("Couldn't create new file. Quitting.");
                e.printStackTrace();
                return;
            }

        } catch (Exception e){
            System.err.println("Couldn't create or read from file. Quitting.");
            e.printStackTrace();
            return;
        }

        try{
            switch(args[1]){
                case "Vehicle":
                    view = new VehicleView("Vehicle Editor");
                    controller = new VehicleController(model, view);
                    break;
                case "Car":
                    view = new CarView();
                    controller = new CarController((Car)model, (CarView)view);
                    break;
                case "Tram":
                    view = new TramView();
                    controller = new TramController((Tram)model, (TramView) view);
                    break;
                default:
                    printUsage();
                    return;
            }
        }
        catch(Exception e){
            System.err.println("Couldn't create view. Are you sure data matches object type?");
            e.printStackTrace();
            return;
        }
        
        controller.initView();
        view.init();
        view.setVisible(true);
    }
}
