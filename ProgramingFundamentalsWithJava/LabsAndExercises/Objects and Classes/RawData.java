import javax.swing.plaf.metal.MetalSliderUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carInfo=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Car car = new Car();
            car.setModel(input[0]);
           car.setEngineSpeed(Integer.parseInt(input[1]));
           car.setEnginePower(Integer.parseInt(input[2]));
           car.setCargoWeight(Integer.parseInt(input[3]));
            car.setCargoType(input[4]);
            car.setTyre1Pressure(Double.parseDouble(input[5]));
            car.setTyre1Age(Integer.parseInt(input[6]));
            car.setTyre2Pressure(Double.parseDouble(input[7]));
            car.setTyre2Age(Integer.parseInt(input[8]));
            car.setTyre3Pressure(Double.parseDouble(input[9]));
            car.setTyre3Age(Integer.parseInt(input[10]));
            car.setTyre4Pressure(Double.parseDouble(input[11]));
            car.setTyre4Age(Integer.parseInt(input[12]));
            carInfo.add(car);
        }
        String checkModel = scanner.nextLine();
        List<String> model = new ArrayList<>();
        switch (checkModel){


            case("fragile"):


                for (int j = 0; j < carInfo.size(); j++) {

                    if (carInfo.get(j).getTyre1Pressure() < 1 || carInfo.get(j).getTyre2Pressure() < 1
                            || carInfo.get(j).getTyre3Pressure() < 1 || carInfo.get(j).getTyre4Pressure() < 1) {
                        model.add(carInfo.get(j).getModel());
                    }
                }

                break;
            case("flamable"):
                for (int j = 0; j < carInfo.size(); j++) {

                    if (carInfo.get(j).getEnginePower() >= 250){
                        model.add(carInfo.get(j).getModel());
                    }
                }
                break;

        }
        model.forEach(System.out::println);


    }
    private static class Car{

        String model;
        int engineSpeed;
        int enginePower;
        int cargoWeight;
        String cargoType;
       double tyre1Pressure;
        int tyre1Age;
        double tyre2Pressure;
        int tyre2Age;
        double tyre3Pressure;
        int tyre3Age;
        double tyre4Pressure;
        int tyre4Age;

        public void setModel(String model) {
            this.model = model;
        }

        public void setEngineSpeed(int engineSpeed) {
            this.engineSpeed = engineSpeed;
        }

        public void setEnginePower(int enginePower) {
            this.enginePower = enginePower;
        }

        public void setCargoWeight(int cargoWeight) {
            this.cargoWeight = cargoWeight;
        }

        public void setCargoType(String cargoType) {
            this.cargoType = cargoType;
        }

        public void setTyre1Pressure(double tyre1Pressure) {
            this.tyre1Pressure = tyre1Pressure;
        }

        public void setTyre1Age(int tyre1Age) {
            this.tyre1Age = tyre1Age;
        }

        public void setTyre2Pressure(double tyre2Pressure) {
            this.tyre2Pressure = tyre2Pressure;
        }

        public void setTyre2Age(int tyre2Age) {
            this.tyre2Age = tyre2Age;
        }

        public void setTyre3Pressure(double tyre3Pressure) {
            this.tyre3Pressure = tyre3Pressure;
        }

        public void setTyre3Age(int tyre3Age) {
            this.tyre3Age = tyre3Age;
        }

        public void setTyre4Pressure(double tyre4Pressure) {
            this.tyre4Pressure = tyre4Pressure;
        }

        public void setTyre4Age(int tyre4Age) {
            this.tyre4Age = tyre4Age;
        }

        public String getModel() {
            return model;
        }

        public int getEngineSpeed() {
            return engineSpeed;
        }

        public int getEnginePower() {
            return enginePower;
        }

        public int getCargoWeight() {
            return cargoWeight;
        }

        public String getCargoType() {
            return cargoType;
        }

        public double getTyre1Pressure() {
            return tyre1Pressure;
        }

        public int getTyre1Age() {
            return tyre1Age;
        }

        public double getTyre2Pressure() {
            return tyre2Pressure;
        }

        public int getTyre2Age() {
            return tyre2Age;
        }

        public double getTyre3Pressure() {
            return tyre3Pressure;
        }

        public int getTyre3Age() {
            return tyre3Age;
        }

        public double getTyre4Pressure() {
            return tyre4Pressure;
        }

        public int getTyre4Age() {
            return tyre4Age;
        }
    }


}
