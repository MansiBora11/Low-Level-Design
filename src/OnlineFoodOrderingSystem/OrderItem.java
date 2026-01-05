public class OrderItem {
    private Item item;
    private int quantity;
    private double orderedPrice;

    public OrderItem(Item item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.orderedPrice = price;
    }

    public Item getItem() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }

    public double getOrderedPrice() {
        return orderedPrice;
    }

    public double getTotalPrice() {
        return orderedPrice * quantity;
    }

}
