package ua.edu.ucu.flower.store.FlowerStrore;

import lombok.Getter;
import lombok.Setter;


@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;
    @Getter
    private FlowerSpecs flowerSpecifications;

    public Flower() {

    }

    public Flower(FlowerType flowerT) {
        this.flowerType = flowerT;
        this.setFlowerSpecifications();
    }

    public Flower(double sepal, FlowerColor colorFlower, double price,
     FlowerType flowerType) {
        this.sepalLength = sepal;
        this.price = price;
        this.flowerType = flowerType;
        this.color = colorFlower;
        this.setFlowerSpecifications();
    }

    public String getColor() {
        return color.toString();
    }

    private void setFlowerSpecifications() {
        this.flowerSpecifications = new FlowerSpecs(this.sepalLength, 
        this.color, this.flowerType);
    }

    public void setColor(FlowerColor colorF) {
        this.color = colorF;
        this.setFlowerSpecifications();
    }

    @Override
    public String toString() {
        return getColor() + flowerType.toString();
    }


}