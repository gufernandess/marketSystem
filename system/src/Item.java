public class Item {

    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %.2f]", product.toString(), quantity, getTotalValue());
    }
}