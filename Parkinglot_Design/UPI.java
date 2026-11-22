package Parkinglot_Design;
public class UPI implements PaymentStrategy {
    @Override
    public PAYMENTSTATUS processPayment(int amount) {
        System.out.println("Processing UPI payment of amount: " + amount);
        return PAYMENTSTATUS.SUCCESS;
    }
}
