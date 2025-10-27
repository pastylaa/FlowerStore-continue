package ua.edu.ucu.flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.edu.ucu.flower.store.payment.CreditCardPaymentStrategy;
import ua.edu.ucu.flower.store.payment.PayPalPaymentStrategy;


public class PaymentStrategyTest {
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
    public void testPayPal() {
        PayPalPaymentStrategy payPalStrategy = new PayPalPaymentStrategy();
        order.setPaymentStrategy(payPalStrategy);

        double priceWithoutTax = order.getTotalPrice();
        double newPrice = payPalStrategy.pay(priceWithoutTax);

        Assertions.assertEquals(priceWithoutTax + 3, newPrice);
    }

    @Test
    public void testCreditCard() {
        CreditCardPaymentStrategy creditStrategy = new CreditCardPaymentStrategy();
        order.setPaymentStrategy(creditStrategy);

        double priceWithoutTax = order.getTotalPrice();
        double newPrice = creditStrategy.pay(priceWithoutTax);

        Assertions.assertEquals(priceWithoutTax + 1, newPrice);
    }
}