package ua.edu.ucu.flower.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.edu.ucu.flower.store.Flower;
import ua.edu.ucu.flower.store.FlowerBucket;
import ua.edu.ucu.flower.store.FlowerColor;
import ua.edu.ucu.flower.store.FlowerPack;
import ua.edu.ucu.flower.store.FlowerType;
import ua.edu.ucu.flower.store.Item;
import ua.edu.ucu.flower.store.Order;
import ua.edu.ucu.flower.store.payment.CreditCardPaymentStrategy;
import ua.edu.ucu.flower.store.payment.PayPalPaymentStrategy;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final Order order = new Order();

    public PaymentController() {
        FlowerBucket bucket = new FlowerBucket();
        bucket.add(new FlowerPack(new Flower(10, FlowerColor.RED, 50.0, FlowerType.ROSE), 3));

        Item item = new Item();
        item.setOrderBucket(bucket);

        order.addItem(item);
    }

    @GetMapping("/creditcard")
    public String setCreditCard() {
        order.setPaymentStrategy(new CreditCardPaymentStrategy());
        double price = order.getPaymentStrategy().pay(order.getTotalPrice());
        return "Payment set to Credit Card. Price now is " + price;
    }

    @GetMapping("/paypal")
    public String setPayPal() {
        order.setPaymentStrategy(new PayPalPaymentStrategy());
        double price = order.getPaymentStrategy().pay(order.getTotalPrice());
        return "Payment set to PayPal. Price now is " + price;
    }
}