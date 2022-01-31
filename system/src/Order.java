import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Order {
  private static int counterId = 0;
  private int id;
  private List<Item> itens = new ArrayList<>();
  private double price;
  private Date date;
  private Client client;
  private Employee employee;

  public Order(List<Item> itens, double price, Date date, Employee employee, Client client) {
    if (itens != null) {
      this.itens.addAll(itens);
    }
    this.price = price;
    this.date = date;
    this.employee = employee;
    this.client = client;
    Order.counterId++;
    this.id = counterId;
  }

  public double computeBill() {
    double sum = 0.0;

    for (Item item : itens) {
      sum += item.getTotalValue();
    }

    return sum;
  }

}
