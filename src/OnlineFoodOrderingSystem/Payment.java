public class Payment {

    private String paymentId;
    private double amount;
    private PaymentStatus status;
    private PaymentMode paymentMode;

    public Payment(String paymentId, double amount, PaymentMode paymentMode) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.status = PaymentStatus.CREATED;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void markSuccess() {
        this.status = PaymentStatus.SUCCESS;
    }

    public void markFailed() {
        this.status = PaymentStatus.FAILED;
    }
}
