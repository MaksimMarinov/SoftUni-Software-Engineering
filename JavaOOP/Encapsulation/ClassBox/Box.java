package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }



    private void setHeight(double height) {
        if (height <=0) {
            throw new IllegalStateException("Height cannot be zero or negative.");
        } else {
            this.height = height;
        }
    }


    private void setWidth(double width) {
        if (width <=0) {
            throw new IllegalStateException("Width cannot be zero or negative.");
        } else {
            this.width = width;
        }
    }


    private void setLength(double length) {
        if (length <=0) {
            throw new IllegalStateException("Length cannot be zero or negative.");
        }
            this.length = length;

    }


    public double calculateSurfaceArea() {
        return 2*this.length*this.width+2*this.length*this.height+2*this.width*this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }
    public double calculateVolume(){
        return this.length*this.width*this.height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume – %.2f",
                this.calculateSurfaceArea(),
        this.calculateLateralSurfaceArea(),
        this.calculateVolume());

    }
}
