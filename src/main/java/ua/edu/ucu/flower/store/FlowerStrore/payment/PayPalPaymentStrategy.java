package ua.edu.ucu.flower.store.FlowerStrore.payment;

public class PayPalPaymentStrategy implements PaymentStrategy{
    @Override
    public double pay(double price){
        System.out.println("Payment is made via PayPal");
        return price + 3;
    }
}