import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final List<OrderItem> orderItems = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    public Order() {
        this.orderId = UUID.randomUUID().toString();
    }

    public void addOrderItems(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    public List<OrderItem> getOrderItems(){
        return orderItems;
    }

    public double calculateTotalAmount(){
        return orderItems.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public Payment createPayment(PaymentMode paymentMode){
        Payment payment = new Payment(UUID.randomUUID().toString(), calculateTotalAmount(), paymentMode);
        payments.add(payment);
        return payment;
    }

    public List<Payment> getPayments(){
        return payments;
    }
}
