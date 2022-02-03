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

  /**
   * O objeto SimpleDateFormat serve para formatação de datas, nesse caso
   * para o modelo comumente usado no Brasil(dd/mm/yyyy).
   * 
   * Pelo fato de a formatação gerar uma string, a mesma só é utilizada
   * para mostrar a data em listas.
   */

  SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

  public Order(List<Item> itens, Client client) {
    Order.counterId++;
    this.id = counterId;
    this.itens = new ArrayList<Item>();
    if (itens != null) this.itens.addAll(itens);
    this.price = computeBill();
    this.date = new Date(System.currentTimeMillis());
    this.client = client;
  }

  /**
   * Os métodos utilitários aqui servem somente para o propósito de adicionar item ao carrinho.
   * 
   * Devido aos seus complexos casos de uso, o ato de adicionar item ao carrinho requer a
   * manipulação tanto do carrinho quanto dos produtos disponíveis em estoque, logo é
   * Necessário a comparação constante entre ambas as listas.
   * 
   * @param productName
   * @return
   */

  private boolean isTheProductInStock(String productName) {
    boolean isTheProductInStock = false;
    for (int i = 0; i < Menu.stock.getProductsList().size(); i++) {
        if (productName.equals(Menu.stock.getProductsList().get(i).getName())) {
          isTheProductInStock = true;
        }
    }

    return isTheProductInStock;
}

private boolean isTheProductInBuyList(String productName) {
  boolean isTheProductInBuyList = false;
  for(int i = 0; i < itens.size(); i++) {
    if(productName.equals(itens.get(i).getProduct().getName())) {
      isTheProductInBuyList = true;
    }
  }
  return isTheProductInBuyList;
}


private int findProductId(String productName) {
  int findProductId = -1;
  for (int i = 0; i < Menu.stock.getProductsList().size(); i++) {
      if (productName.equals(Menu.stock.getProductsList().get(i).getName())) {
        findProductId = i;
      }
  }

  return findProductId;
}

private int findItemId(Item item) {
  int findItemId = -1;
  for (int i = 0; i < itens.size(); i++) {
      if (item.getProduct().getName().equals(itens.get(i).getProduct().getName())) {
        findItemId = i;
      }
  }

  return findItemId;
}

  public int getId() { return id; }

  public List<Item> getItens() { return itens; }

  public double getPrice() { return price; }

  public Client getClient() { return client; }

  public Date getDate() { return date; }

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
      System.out.println("\nItem não pode ser nulo.\n");
      return false;
    }

    if (item.getProduct() == null) {
      System.out.println("\nDeve existir um produto a ser adicionado.\n");
      return false;
    }

    if (item.getQuantity() <= 0) {
      System.out.println("\nDeve haver pelo menos uma unidade do produto.\n");
      return false;
    }

    if(isTheProductInStock(item.getProduct().getName()) == false || 
    Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).getQuantity() == 0) {
      System.out.println("\nEsse produto não está disponível no estoque.\n");
      return false;
    }

    else {
      int productStockQtd = Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).getQuantity();
      
      if(isTheProductInBuyList(item.getProduct().getName())) {
        if(item.getQuantity() >= productStockQtd) {
          itens.get(findItemId(item)).setQuantity(itens.get(findItemId(item)).getQuantity() + productStockQtd);
          Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).setQuantity(0);
          System.out.println("\nO item que você tentou adicionar já está no carrinho, colocamos a quantidade desejada seu no carrinho.\n");
          return true;
        }

        else {
          Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).
          setQuantity(productStockQtd - item.getQuantity());
          itens.get(findItemId(item)).setQuantity(itens.get(findItemId(item)).getQuantity() + item.getQuantity());
          System.out.println("\nO item que você tentou adicionar já está no carrinho, colocamos a quantidade desejada seu no carrinho.\n");
          return true;
        }

      } 
      else {
        if(item.getQuantity() >= productStockQtd) {
          item.setQuantity(productStockQtd);
          Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).setQuantity(0);
          itens.add(item);
          System.out.println("\nO item foi adicionado com sucesso.\n");
          return true;
        }

        else {
          Menu.stock.getProductsList().get(findProductId(item.getProduct().getName())).
          setQuantity(productStockQtd - item.getQuantity());
          itens.add(item);
          System.out.println("\nO item foi adicionado com sucesso.\n");
          return true;
        }

      }
    }
  }

  public boolean removeItem(int idItem) {
    System.out.println("\nItem removido com sucesso.\n");
    return (this.itens.get(idItem) != null) ? this.itens.remove(this.itens.get(idItem)) : false;
  }

  public void finalizeOrder() {
    System.out.println("\nCompra finalizada.\n");
    // return new Invoice(this.id, this.itens, this.price, this.date, this.client); /* Instância da nota fiscal */
  }

  @Override
  public String toString() {
    return String.format("\n\nId: %d, Preço: %.2f, Data: %s \nDados do cliente: %s\n\n", id, computeBill(),
    formatDate.format(date), client.toString());
  }

}
