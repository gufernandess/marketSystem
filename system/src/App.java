public class App {

  /**
   * Dentro da classe main nós chamamos o método static login.
   * 
   * A classe Menu possui métodos estáticos para que seja possível chamá-los
   * e fazer um fluxo entre as funcionalidades do sistema.
   * 
   * @param args
   */
  public static void main(String[] args) {
    Menu.loadingData();
    Menu.login();
  }
}
