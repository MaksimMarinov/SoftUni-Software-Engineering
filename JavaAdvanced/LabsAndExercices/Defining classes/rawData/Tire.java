package rawData;

public class Tire {
    private double pressure;
    private int age;


    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }


    @Override
    public String toString() {
        return String.format("%d, %.1f", this.age, this.pressure);
    }
}
