public class PaymentService {
    public void processPayment(Order order, Payment payment){
        PaymentStrategy paymentStrategy = PaymentFactory.getStrategy(payment.getPaymentMode());

        try{
            paymentStrategy.pay(payment.getAmount());
            payment.markSuccess();
            System.out.println("Payment successful");
        }catch (Exception e){
            payment.markFailed();
            System.out.println("Payment failed");
        }
    }
}
