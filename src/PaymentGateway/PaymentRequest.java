public class PaymentRequest {
    private double amount;
    private String currency;
    private String paymentMethodType;

    public PaymentRequest(double amount, String currency, String paymentMethodType) {
        this.amount = amount;
        this.currency = currency;
        this.paymentMethodType = paymentMethodType;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }
}
