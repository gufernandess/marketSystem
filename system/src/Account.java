public class Account {

  private static int counterId = 0;
  private int id;
  private String username;
  private String email;
  private String password;

  public Account(String username, String email, String password) {
    Account.counterId++;
    this.id = counterId;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public int getId() {
      return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public int getPassword() {
    return password.hashCode();
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return String.format("Nome: %s, Email: %s, Senha(hashcode): %d", username, email, password);
  }
}