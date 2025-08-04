import java.util.Arrays;

/*
 * When we need to create a class object with different options, but we require complex logic to form their values, then use builder desing pattern.
 */

class Car{
    public int seats;
    public int gears;
    public String[] modes;
    public String color;
    public int price;
    private Car(Builder builder) {
        this.seats = builder.seats;
        this.gears = builder.gears;
        this.modes = builder.modes;
        this.color = builder.color;
        this.price = builder.price;
    }

    

    @Override
    public String toString() {
        return "Car [seats=" + seats + ", gears=" + gears + ", modes=" + Arrays.toString(modes) + ", color=" + color
                + ", price=" + price + "]";
    }



    static class Builder{
        private int seats;
        private int gears;
        private String[] modes;
        private String color;
        private int price;

        public Builder setSeats(int seats) {
            System.out.println("Please read the seat size and ventilation system properly...");
            this.seats = seats;
            return this;
        }
        public Builder setGears(int gears) {
            System.out.println("Your lovely car has " + gears + " gears...");
            this.gears = gears;
            return this;
        }
        public Builder setModes(String[] modes) {
            System.out.println("Your loverly car has " + String.join(", ", modes) + " modes");
            this.modes = modes;
            return this;
        }
        public Builder setColor(String color) {
            this.color = color;
            return this;
        }
        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Car getCar(){
            return new Car(this);
        }
    }
}


public class BuilderPattern {
    public static void main(String[] args) {
        Car swift = new Car.Builder()
        .setColor("Red")
        .setGears(6)
        .setModes(new String[]{"City", "Sport", "Eco"})
        .setPrice(1000000)
        .setSeats(7)
        .getCar();

        System.out.println("Your car... " + swift);

    }
}
