public class PaymentMethodFactory {
    public static PaymentMethod getPaymentMethod(String type){
        switch(type){
            case "CARD":
                return new CreditCardPayment();
            case "UPI":
                return new UpiPayment();
            default:
                throw new IllegalArgumentException("Unsupported payment method.");
        }
    }
}
