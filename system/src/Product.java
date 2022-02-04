// import java.util.Date;

/**
 * Esta classe representa os produtos que serão adicionados ao estoque
 * e vendidos aos clientes.
 */

public class Product implements Comparable<Product> {
  
  private static int counterId = 0;
  private int id;
  private String name;
  private double price;
  private int quantity;

  public Product(String name, double price, int quantity) {
    Product.counterId++;
    this.id = counterId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public int getId() { return id; }

  public String getName() { return name; }

  public double getPrice() { return price; }

  public int getQuantity() { return quantity; }

  public void setName(String name) { this.name = name; }

  public void setPrice(double price) { this.price = price; }

  public void setQuantity(int quantity) { this.quantity = quantity; }

  @Override
  public int compareTo(Product product) {
      return this.name.compareTo(product.name);
  }

  @Override
  public String toString() {
    return String.format("\n\nID: %d, Nome: %s, Preço: %.2f, Quantidade: %d\n\n", id, name, price, quantity);
  }
}