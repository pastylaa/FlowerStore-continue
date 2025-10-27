package ua.edu.ucu.flower.store.delivery;
import java.util.List;

import ua.edu.ucu.flower.store.Item;

public class PostDeliveryStrategy implements DeliveryStrategy{
    @Override
    public double deliver(List<Item> orders, double price){
        System.out.println("Delivering " + String.valueOf(orders.size()) + "items with Post Delivery");
        return price + 5;
    }
}