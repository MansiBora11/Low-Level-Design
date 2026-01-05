public class PaymentFactory {
    public static PaymentStrategy getStrategy(PaymentMode paymentMode){
        switch (paymentMode){
            case UPI -> {
                return new UpiPaymentStrategy();
            }
            case CARD -> {
                return new CardPaymentStrategy();
            }
            default ->
            {
                throw new IllegalArgumentException("Unsupported payment mode.");
            }
        }
    }
}
