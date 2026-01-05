public class Item {
    private String itemId;
    private String name;
    private double currentPrice;

    public Item(String itemId, String name, double currentPrice) {
        this.itemId = itemId;
        this.name = name;
        this.currentPrice = currentPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
