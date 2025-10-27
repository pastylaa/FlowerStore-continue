package ua.edu.ucu.flower.store.delivery;
import java.util.List;

import ua.edu.ucu.flower.store.Item;


public interface DeliveryStrategy {
    public double deliver(List<Item> orders, double price);
}