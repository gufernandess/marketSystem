/**
 * Um item(conjunto) é representando por um produto(unidade) e um atributo que
 * denomina a quantidade de produtos.
 */
public class Item implements Comparable<Item> {

    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Este método retorna o valor total do conjunto item.
     * 
     * @return double
     * 
     */

    public double getTotalValue() { return product.getPrice() * quantity; }

    public Product getProduct() { return this.product; }

    public int getQuantity() { return this.quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public int compareTo(Item item) {
        return this.product.getName().compareTo(item.product.getName());
    }

    @Override
    public String toString() {
        return String.format("\nID: %d, Nome do produto: %s, Preço: %.2f, Quantidade: %d, Valor total da compra: %.2f\n",
         product.getId(), product.getName(), product.getPrice(), product.getQuantity(), getTotalValue());
    }
}