package ua.edu.ucu.flower.store.FlowerStrore.delivery;
import java.util.List;

import ua.edu.ucu.flower.store.FlowerStrore.Item;


public interface DeliveryStrategy {
    public double deliver(List<Item> orders, double price);
}