package ua.edu.ucu.flower.store.FlowerStrore.delivery;

import java.util.List;

import ua.edu.ucu.flower.store.FlowerStrore.Item;

public class DhlDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double deliver(List<Item> orders, double price){
        System.out.println("Delivering " + String.valueOf(orders.size()) + "items with DHL");
        return price + 15;
    }
}