public class UpiPayment implements PaymentMethod{
    @Override
    public PaymentResponse pay(PaymentRequest request) {
        return new PaymentResponse(PaymentStatus.SUCCESS, "UPI5678", "Transaction successful");
    }
}
