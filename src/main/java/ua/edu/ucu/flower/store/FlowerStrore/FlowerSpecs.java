package ua.edu.ucu.flower.store.FlowerStrore;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowerSpecs {
    private double sepalLength;
    private FlowerColor color;
    private FlowerType type;

    public FlowerSpecs(double sepal, FlowerColor color, FlowerType flowerType) {
        this.sepalLength = sepal;
        this.color = color;
        this.type = flowerType;
    }

    public boolean match(FlowerSpecs otherSpecs) {
        if (this.sepalLength != otherSpecs.getSepalLength()) {
            return false;
        }
        
        if (!this.color.equals(otherSpecs.getColor())) {
            return false;
        }

        if (this.type != otherSpecs.getType()) {
            return false;
        }

        return true;
    }

    public boolean match(FlowerPack pack) {
        return match(pack.getFlower().getFlowerSpecifications());
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public FlowerColor getColor() {
        return color;
    }

    public void setColor(FlowerColor color) {
        this.color = color;
    }

    public FlowerType getType() {
        return type;
    }

    public void setType(FlowerType type) {
        this.type = type;
    }
    
}