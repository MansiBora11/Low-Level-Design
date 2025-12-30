public class Main {
    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest(1000, "INR", "CARD");

        PaymentGateway gateway = new PaymentGateway();
        PaymentResponse response = gateway.processPayment(request);
        System.out.println(response);
    }


}
