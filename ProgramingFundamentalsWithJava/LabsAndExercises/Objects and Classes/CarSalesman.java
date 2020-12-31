import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carInfo = new ArrayList<>();
        List<Engine> engineInfo = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String[] inputEngineInfo = scanner.nextLine().split("\\s+");
            Engine engine = new Engine();
            engine.setModel(inputEngineInfo[0]);
            engine.setPower(inputEngineInfo[1]);
            if(inputEngineInfo.length==4) {
                engine.setDisplacement(inputEngineInfo[2]);
                engine.setEfficiency(inputEngineInfo[3]);
            }else if(inputEngineInfo.length==3) {
                if(isNum(inputEngineInfo[2])) {
                    engine.setDisplacement(inputEngineInfo[2]);
                }else {
                    engine.setEfficiency(inputEngineInfo[2]);
                }
            }

            engineInfo.add(engine);



        }
        for (int i = 0; i <m ; i++) {
            String[] inputCarsInfo = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setModel(inputCarsInfo[0]);

            if(inputCarsInfo.length==4){
                car.setColor(inputCarsInfo[3]);
                car.setWeight(inputCarsInfo[2]);
            }else {
                if(isNum(inputCarsInfo[2])){
                    car.setWeight(inputCarsInfo[2]);
                }else{
                    car.setColor(inputCarsInfo[2]);
                }
            }
            carInfo.add(car);
            }




        }



    public static class Car{
        String model;
        Engine engine;
        String weight;
        String color;

        public Car() {
            this.weight ="n/a";
            this.color = "n/a";
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

    }
    public static class Engine{
        String model;
        String power;
        String displacement;
        String efficiency;

        public Engine() {
            this.displacement = "n/a";
            this.efficiency = "n/a";
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }
    private static boolean isNum(String s) {
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }


}

