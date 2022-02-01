import java.util.Date;

public class Product {
  
  private static int counterId = 0;
  private int id;
  private String name;
  private double price;
  private int quantity;
  private String description;
  private Date manufacturingDate;
  private Date expirationDate;

  public Product(String name, double price, int quantity, String description, Date manufacturingDate, Date expirationDate) {
    Product.counterId++;
    this.id = counterId;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.description = description;
    this.expirationDate = expirationDate;
    this.manufacturingDate = manufacturingDate;
  }

  public int getId() {
      return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
      return quantity;
  }

  public String getDescription() {
    return description;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public Date getManufacturingDate() {
    return manufacturingDate;
  }


  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
      this.quantity = quantity;
  }

  @Override
  public String toString() {
    return String.format("ID: %d, Nome: %s, Preço: %.2f, Descrição: %s, Data de fabricação: %s, Data de validade: %s",
     id, name, price, description, manufacturingDate.toString(), expirationDate.toString());
  }

}