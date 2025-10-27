package ua.edu.ucu.flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.edu.ucu.flower.store.delivery.DhlDeliveryStrategy;
import ua.edu.ucu.flower.store.delivery.PostDeliveryStrategy;


public class DeliveryStrategyTest {
    private Order order;

    @BeforeEach
    public void setOrder() {
        order = new Order();

        Flower rose = new Flower(10, FlowerColor.RED, 50, FlowerType.ROSE);
        FlowerPack pack = new FlowerPack(rose, 3);

        FlowerBucket bucket = new FlowerBucket();
        bucket.add(pack);

        Item item = new Item();
        item.setOrderBucket(bucket);

        order.addItem(item);
    }

    @Test
    public void testDhlDelivery() {
        DhlDeliveryStrategy dhlStrategy = new DhlDeliveryStrategy();
        order.setDeliveryStrategy(dhlStrategy);

        double priceWithoutDelivery = order.getTotalPrice();
        double newPrice = dhlStrategy.deliver(order.getOrders(), priceWithoutDelivery);

        Assertions.assertEquals(priceWithoutDelivery + 15, newPrice);
    }

     @Test
    public void testPostDelivery() {
        PostDeliveryStrategy postStrategy = new PostDeliveryStrategy();
        order.setDeliveryStrategy(postStrategy);

        double priceWithoutDelivery = order.getTotalPrice();
        double newPrice = postStrategy.deliver(order.getOrders(), priceWithoutDelivery);

        Assertions.assertEquals(priceWithoutDelivery + 5, newPrice);
    }
}