import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSeller {
    private final List<Car> cars;

    public CarSeller() {
        this.cars = new ArrayList<>();
    }

    public void readFile(File file) throws FileNotFoundException{
        Scanner in=new Scanner(file);
        while(in.hasNextLine()){
            String brand=in.next();
            String modello=in.next();
            int annoImmatricolazione=in.nextInt();
            double prezzo=in.nextDouble();
            Car car=new Car(brand,modello,annoImmatricolazione,prezzo);
            this.cars.add(car);
        }
    }

    public List<Car> ricercaMarcaEModello(String brand, String modello){
        List<Car> autoTrovate=new ArrayList<>();
        for(Car car: this.cars){
            if(car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(modello)){
                autoTrovate.add(car);
            }
        }
        return autoTrovate;
    }

    public List<Car> ricercaMarcaEModelloAnno(String brand, String modello, int immatricolazione){
        List<Car> autoTrovate=new ArrayList<>();
        for(Car car: this.cars){
            if(car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(modello) && car.getManufacturingYear()>=immatricolazione){
                autoTrovate.add(car);
            }
        }
        return autoTrovate;
    }

    public List<Car> ricercaMarcaEModelloPrezzo(String brand, String modello, double prezzoMin, double prezzoMax){
        List<Car> autoTrovate=new ArrayList<>();
        for(Car car: this.cars){
            if(car.getBrand().equalsIgnoreCase(brand) && car.getModel().equalsIgnoreCase(modello) && car.getPrice()>=prezzoMin && car.getPrice()<=prezzoMax ){
                autoTrovate.add(car);
            }
        }
        return autoTrovate;
    }

}