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

  public Stock() {
    productsList = new ArrayList<Product>();
  }


  public List<Product> getProductsList() {
    return productsList;
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

  public int findProductId(String productName) {
    int findProductId = -1;
    for (int i = 0; i < productsList.size(); i++) {
        if (productName.equals(productsList.get(i).getName())) {
          findProductId = i;
        }
    }
  
    return findProductId;
  }

  public boolean addProduct(Product product) {
    if (productAlreadyExists(product.getName())) {
      System.out.println("\nParece que este produto já está cadastrado no sistema.\n");
      return false;
    } else {
      productsList.add(product);
      System.out.println("\nO produto foi adicionado com sucesso.\n");
      return true;
    }
  }

  public boolean deleteProduct(int idProduct) {
    if (productsList.get(idProduct - 1) != null) {
      productsList.remove(productsList.get(idProduct - 1));
      System.out.println("\nO produto foi removido com sucesso.\n");
      return true;
    } else {
      System.out.println("\nProduto não encontrado.\n");
      return false;
    }
  }

  public boolean updateProductName(int idProduct, String newName) {
    if (productsList.get(idProduct - 1) != null) {
      if (productAlreadyExists(newName) == false) {
          productsList.get(idProduct - 1).setName(newName);
          System.out.println("\nO nome do produto foi atualizado com sucesso.\n");
          return true;
      } else {
          System.out.println("\nEste produto já está cadastrado no nosso sistema.\n");
          return false;
      }
  } else {
      System.out.println("\nEste produto não foi encontrada no sistema.\n");
      return false;
  }
} 

  public boolean updateProductPrice(int idProduct, double newPrice) {
    if(productsList.get(idProduct - 1) != null) {
      productsList.get(idProduct - 1).setPrice(newPrice);
      System.out.println("\nO preço do produto foi atualizado com sucesso.\n");
      return true;
  } else {
      System.out.println("\nEste produto não foi encontrado no sistema.\n");
      return false;
  }
} 

  public boolean updateProductQuantity(int idProduct, int newQuantity) {
    if(newQuantity <= 0) {
      System.out.println("\nInsira uma quantidade válida.\n");
      return false;
    }
    if(productsList.get(idProduct - 1) != null) {
      productsList.get(idProduct - 1).setQuantity(productsList.get(idProduct - 1)
      .getQuantity() + newQuantity);
      System.out.println("\nA quantidade do produto disponível foi atualizada.\n");
      return true;
  } 
    else {
      System.out.println("\nEste produto não foi encontrado no sistema.\n");
      return false;
  }
} 

  /**
   * Método de pesquisa de produtos que gera uma nova lista baseada no pattern passado como parâmetro.
   * 
   * @param pattern
   * @return
   */

  List<Product> search(String pattern) {
    List<Product> searchResult = new ArrayList<Product>();

    for (int i = 0; i < productsList.size(); i++) {
      if (productsList.get(i) != null && productsList.get(i).getName().contains(pattern)) {
        searchResult.add(productsList.get(i));
      }
    }

    System.out.println("\n" + searchResult + "\n");

    return searchResult;
  }

  public String toString() {
    StringBuilder products = new StringBuilder();

    System.out.println("\n----------PRODUTOS----------");
    System.out.println("\nID | Nome | Preço | Quantidade\n");

    for (int i = 0; i < productsList.size(); i++) {
      products.append(productsList.get(i).getId() + " | " + productsList.get(i).getName() + " | " +
          productsList.get(i).getPrice() + " | " + productsList.get(i).getQuantity() + " | \n");
    }

    return products.toString();
  }
}
