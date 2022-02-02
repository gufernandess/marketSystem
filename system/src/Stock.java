import java.util.ArrayList;
import java.util.List;

/**
 * Dentro da classe Stock(Estoque) são armazenados todos os produtos disponíveis.
 * Todos os produtos retirados para venda são retirados daqui.
 * 
 * @param productsList
 * 
 */

public class Stock {

  private List<Product> productsList;

  public Stock(List<Product> list) {
    productsList = new ArrayList<Product>();
    if (list != null) productsList.addAll(list);
  }

  private boolean productAlreadyExists(String name) {
    boolean productAlreadyExists = false;
    for (int i = 0; i < productsList.size(); i++) {
      if (name.equals(productsList.get(i).getName())) {
        productAlreadyExists = true;
      }
    }

    return productAlreadyExists;
  }

  /*private Product findProductById(int id) {
    int idProduct = -1;
    for (int i = 0; i < productsList.size(); i++) {
      if (id == productsList.get(i).getId()) {
        idProduct = i;
      }
    }

    return idProduct != -1 ? productsList.get(idProduct) : null;
  }*/

  public boolean addProduct(Product product) {
    if (productAlreadyExists(product.getName())) {
      System.out.println("Parece que este produto já está cadastrado no sistema.\n");
      return false;
    } else {
      productsList.add(product);
      return true;
    }
  }

  public boolean deleteProduct(int idProduct) {
    if (productsList.get(idProduct) != null) {
      productsList.remove(productsList.get(idProduct));
      return true;
    } else {
      System.out.println("Produto não encontrado.\n");
      return false;
    }
  }

  // public boolean updateProduct(Product product) {} Atualizar qual atributo
  // especificamente?

  /**
   * Método de pesquisa de produtos que gera uma nova lista baseada no pattern passado como parâmetro.
   * 
   * @param pattern
   * @return
   */

  public List<Product> search(String pattern) {
    List<Product> searchResult = new ArrayList<Product>();

    for (int i = 0; i < productsList.size(); i++) {
      if (productsList.get(i) != null && productsList.get(i).getName().contains(pattern)) {
        searchResult.add(productsList.get(i));
      }
    }

    return searchResult;
  }

  public String toString() {
    StringBuilder products = new StringBuilder();

    System.out.println("----------PRODUTOS----------");
    System.out.println("\nID | Nome | Preço | Quantidade | Descrição | D. Fabricação | D. Validade\n");

    for (int i = 0; i < productsList.size(); i++) {
      products.append(productsList.get(i).getId() + " | " + productsList.get(i).getName() + " | " +
          productsList.get(i).getPrice() + " | " + productsList.get(i).getQuantity() + " | " +
          productsList.get(i).getDescription() + " | " + productsList.get(i).getManufacturingDate() + " | " +
          productsList.get(i).getExpirationDate() + "\n");
    }

    return products.toString();
  }
}
