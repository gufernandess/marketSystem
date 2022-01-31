import java.util.ArrayList;
import java.util.List;

public class Stock {

  private List<Product> productsList;

  public Stock(List<Product> list) {
    productsList = new ArrayList<Product>();
    if (list != null)
      productsList.addAll(list);
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

  public boolean addProduct(Product product) {
    if (productAlreadyExists(product.getName())) {
      System.out.println("Parece que este produto já está cadastrado no sistema.\n");
      return false;
    } else {
      productsList.add(product);
      return true;
    }
  }

  public boolean deleteProduct(int id) {
  }

  public boolean updateProduct(Product product) {
  }

  private List<Product> search(String Pattern) {
  }

  public String toString() {
  }
}