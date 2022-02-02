import java.util.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Representação de uma compra feita por um cliente.
 */

public class Order {

  private static int counterId = 0;
  private int id;
  private List<Item> itens;
  private double price;
  private Date date;
  private Client client;
  private Employee employee;

  /**
   * O objeto SimpleDateFormat serve para formatação de datas, nesse caso
   * para o modelo comumente usado no Brasil(dd/mm/yyyy).
   * 
   * Pelo fato de a formatação gerar uma string, a mesma só é utilizada
   * para mostrar a data externamente.
   */

  SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

  public Order(List<Item> itens, Employee employee, Client client) {
    Order.counterId++;
    this.id = counterId;
    this.itens = new ArrayList<Item>();
    if (itens != null) this.itens.addAll(itens);
    this.price = computeBill();
    this.date = new Date(System.currentTimeMillis());
    this.employee = employee;
    this.client = client;
  }

  /**
   * Computando valor total do pedido
   * 
   * @return double
   * 
   */

  public double computeBill() {
    double total = 0.00;

    for (Item item : itens) total += item.getTotalValue();

    return total;
  }

  public boolean addItem(Item item) {
    /**
     * Verifcando possíveis erros de input
     */

    if (item == null) {
      System.out.println("Item não pode ser nulo.\n");
      return false;
    }

    if (item.getProduct() == null) {
      System.out.println("Deve existir um produto a ser adicionado.\n");
      return false;
    }

    if (item.getQuantity() <= 0) {
      System.out.println("Deve pelo menos uma unidade do produto.\n");
      return false;
    }

    /**
     * Se produto passado ja estiver no pedido, ou seja, se item
     * com produto ja esxite, não adiciona esse novo item
     * so adiciona a quantidade ao item ja existente.
     */
    // for (Item itemAux : this.itens) {
    // if (itemAux.getProduct().getName().equals(item.getProduct().getName())) {
    // if( >= item.getProduct().getQuantity())
    // }
    // }

    this.itens.add(item);

    return true;
  }

  private Item findItemById(int idItem) {
    return this.itens.get(idItem);
  }

  public boolean removeItem(int idItem) {
    return (findItemById(idItem) != null) ? this.itens.remove(findItemById(idItem))
        : false;
  }

  public Invoice finalizeOrder() {
    System.out.println("Compra finalizada.\n");
    // Aqui possivelmente vai ter a lógica de adicionar o pedido em relatório

    return new Invoice(this.id, this.itens, this.price, this.date, this.client); /* Instância da nota fiscal */
  }

  @Override
  public String toString() {
    return String.format("Id: %d, Preço: %.2f, Data: %s, Client: %s, Empregado: %s", id, price, 
    formatDate.format(date), client, employee);
  }

}
