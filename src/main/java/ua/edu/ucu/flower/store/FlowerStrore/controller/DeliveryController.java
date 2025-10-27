package ua.edu.ucu.flower.store.FlowerStrore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.flower.store.FlowerStrore.Flower;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerBucket;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerColor;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerPack;
import ua.edu.ucu.flower.store.FlowerStrore.FlowerType;
import ua.edu.ucu.flower.store.FlowerStrore.Item;
import ua.edu.ucu.flower.store.FlowerStrore.Order;
import ua.edu.ucu.flower.store.FlowerStrore.delivery.DhlDeliveryStrategy;
import ua.edu.ucu.flower.store.FlowerStrore.delivery.PostDeliveryStrategy;


@RestController
@RequestMapping("/delivery")
public class DeliveryController{
    private final Order order = new Order();

    public DeliveryController() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(new FlowerPack(new Flower(10, FlowerColor.RED, 50.0, FlowerType.ROSE), 3));

        Item item = new Item();
        item.setOrderBucket(bucket);

        order.addItem(item);
    }

    @GetMapping("/dhl")
    public String setDHl() {
        order.setDeliveryStrategy(new DhlDeliveryStrategy());
        double price = order.getDeliveryStrategy().deliver(order.getOrders(), order.getTotalPrice());
        return "Delivery is made via DHL. New price is " + price;
    }

    @GetMapping("/postdelivery")
    public String setPostDelivery() {
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        double price = order.getDeliveryStrategy().deliver(order.getOrders(), order.getTotalPrice());
        return "Delivery is made via Post Delivery. New price is " + price;
    }
    
}