package Ex7;

import java.util.Arrays;

public class ModelCar {
    private String type;
    private String brand;
    private String color;
    private String model;
    private int weight;


    public ModelCar() {

    }

    public ModelCar(String type, String brand, String model, String color, int weight) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Car Properties: " +
                "Type: " + type +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Color: " + color +
                ", Weight: " + weight;
    }

    public static void main(String[] args) {
        ModelCar car = new ModelCar("SUV", "Toyota", "4Runner", "Grey", 3000);

        System.out.println(car);
    }
}
