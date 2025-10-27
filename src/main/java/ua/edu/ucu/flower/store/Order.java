package ua.edu.ucu.flower.store;

import java.util.ArrayList;
import java.util.List;

import ua.edu.ucu.flower.store.delivery.DeliveryStrategy;
import ua.edu.ucu.flower.store.payment.PaymentStrategy;


public class Order {
    private List<Item> orders = new ArrayList<>();
    private DeliveryStrategy delStrategy;
    private PaymentStrategy payStrategy;

    public void addItem(Item item){
        orders.add(item);
    }

    public List<Item> getOrders() {
        return orders;
    }

    public void setDeliveryStrategy(DeliveryStrategy dStrategy){
        this.delStrategy = dStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy payStrategy){
        this.payStrategy = payStrategy;
    }

    public PaymentStrategy getPaymentStrategy(){
       return payStrategy;
    }

    public DeliveryStrategy getDeliveryStrategy(){
       return delStrategy;
    }

    public void removeItem(Item item){
        orders.remove(item);
    }

    public int getCount(){
        return orders.size();
    }

    public double getTotalPrice(){
        double price = 0;

        for (Item i: orders){
            price += i.getPrice();
        }

        return price;
    }

    public double processOrder() {
        double currPrice = getTotalPrice();

        if (payStrategy != null) {
            payStrategy.pay(currPrice); 
        }

        if (delStrategy != null) {
            currPrice = delStrategy.deliver(orders, currPrice);
        }

        System.out.println("Final price of order is " + currPrice);
        return currPrice;
    }

}