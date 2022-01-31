import java.util.Date;

public class Product {
  private static int counterId = 0;
  private int id;
  private String name;
  private double price;
  private String description;
  private Date expirationDate;
  private Date manufacturingDate;

  public Product(String name, double price, String description, Date expirationDate, Date manufacturingDate) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.expirationDate = expirationDate;
    this.manufacturingDate = manufacturingDate;
    Product.counterId++;
    this.id = counterId;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
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

  @Override
  public String toString() {
    return String.format("[%d, %s, %.2f, %s, %s, %s]", id, name, price, description, expirationDate.toString(),
        manufacturingDate.toString());
  }

}