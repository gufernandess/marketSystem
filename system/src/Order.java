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

  public Order(List<Item> itens, double price, Date date, Employee employee, Client client) {
    if (itens != null) {
      this.itens.addAll(itens);
    }
    Order.counterId++;
    this.id = counterId;
    this.price = price; /* Esse atributo deveria ser dado pelo método computeBill? */
    this.date = date;
    this.employee = employee;
    this.client = client;

    this.invoice = new Invoice(this.id, itens, price, date, client); /* Instância da nota fiscal */
  }

  public double computeBill() {
    double sum = 0.00;

    for(Item item : itens) {
      sum += item.getTotalValue();
    }

    return sum;
  }

  public boolean addItem(Item item) {}

  public boolean removeItem(int idItem) {}

  public String toString() {}

}
