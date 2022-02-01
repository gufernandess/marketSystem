import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representação de uma compra feita por um cliente.
 */

public class Order {
  private static int counterId = 0;
  private int id;
  private List<Item> itens = new ArrayList<>();
  private double price;
  private Date date;
  private Client client;
  private Employee employee;
  private Invoice invoice;

  public Order(List<Item> itens, Date date, Employee employee, Client client) {
    if (itens != null) {
      this.itens.addAll(itens);
    }
    Order.counterId++;
    this.id = counterId;
    this.price = computeBill();
    this.date = date;
    this.employee = employee;
    this.client = client;

    this.invoice = new Invoice(this.id, itens, this.price, date, client); /* Instância da nota fiscal */
  }

  public double computeBill() {
    double total = 0.00;
    for(Item item : itens) total += item.getTotalValue();

    return total;
  }

  public boolean addItem(Item item) {}

  public boolean removeItem(int idItem) {}

  public String toString() {}

}
