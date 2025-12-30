public class CreditCardPayment implements PaymentMethod{
    @Override
    public PaymentResponse pay(PaymentRequest request) {
        //simulate processing
        return new PaymentResponse(PaymentStatus.SUCCESS, "CC1234", "Transaction successful!");
    }
}
