import java.util.HashMap;
import java.util.Map;

public class PaymentGateway {

    private PaymentMethodFactory paymentMethodFactory;

    public PaymentResponse processPayment(PaymentRequest request){
        PaymentMethod paymentMethod = paymentMethodFactory.getPaymentMethod(request.getPaymentMethodType());

        return paymentMethod.pay(request);

    }
}
