import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {
    Map<String, PaymentMethod> paymentMethodMap = new HashMap<>();

    public PaymentGateway(){
        paymentMethodMap.put("CARD", new CreditCardPayment());
        paymentMethodMap.put("UPI", new UpiPayment());
    }

    public PaymentResponse processPayment(PaymentRequest request){
        PaymentMethod paymentMethod = paymentMethodMap.get(request.getPaymentMethodType());

        if(paymentMethod == null){
            throw new IllegalArgumentException("Unsupported payment method.");
        }

        return paymentMethod.pay(request);

    }
}
