package ua.edu.ucu.flower.store.payment;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public double pay(double price){
        System.out.println("Payment is done via CreditCard");
        return price + 1;
    }
}