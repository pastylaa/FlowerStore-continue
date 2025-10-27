package ua.edu.ucu.flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlowerPack {
    private Flower flower;
    private int quantity;

    public FlowerPack(Flower flowerP, int quantityF) {
        this.flower = flowerP;
        this.quantity = quantityF;
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + flower.toString() + ":" + getPrice();
    }

}