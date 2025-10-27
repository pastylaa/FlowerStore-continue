package ua.edu.ucu.flower.store;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private FlowerBucket orderBucket;

    public double getPrice(){
        return orderBucket.getPrice();
    }

    public String getDescription(){
        return orderBucket.toString();
    }
}