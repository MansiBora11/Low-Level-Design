public class Main {
    public static void main(String[] args) {
        Item pizza = new Item("I1", "Pizza", 250);
        Item burger = new Item("I2", "Burger", 150);

        OrderItem orderItem1 = new OrderItem(pizza, 2, pizza.getCurrentPrice());
        OrderItem orderItem2 = new OrderItem(burger, 1, burger.getCurrentPrice());

        Order order = new Order();
        order.addOrderItems(orderItem1);
        order.addOrderItems(orderItem2);

        Payment payment = order.createPayment(PaymentMode.UPI);

        PaymentService paymentService = new PaymentService();
        paymentService.processPayment(order, payment);
    }
}
