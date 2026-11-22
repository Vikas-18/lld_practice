package Parkinglot_Design;
public interface PaymentStrategy {
    PAYMENTSTATUS processPayment(int amount);
}
