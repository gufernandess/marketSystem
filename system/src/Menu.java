import java.util.ArrayList;
import java.util.Scanner;

/**
 * Aqui instanciamos(de forma estática) todas as listas que são acessadas
 * durante a execução do programa.
 * 
 * Basicamente há os métodos de login, cadastro e dashboard. A navegação do
 * sistema passa por eles.
 * 
 * A navegação é feita através do input de inteiros, visto que assim há menos
 * casos de erro.
 * 
 */

public class Menu {
  static AccountListing accountListing = new AccountListing();
  static EmployeeListing employeeListing = new EmployeeListing();
  static Stock stock = new Stock();
  static Report report = new Report();

  /**
   * O login é a tela inicial do sistema, onde é possível entrar na dashboard ou
   * cadastrar uma conta.
   */

  static void loadingData() {
    // lendo dados dos arquivos
    accountListing.readListAccounts();
    employeeListing.readListEmployess();
    stock.readListProducts();
  }

  public static void login() {

    Scanner input = new Scanner(System.in);

    int response;

    System.out.println("\nBem-vindo ao super market system! Como você quer entrar no sistema?\n");
    System.out.println("1 - Logar   2 - Cadastrar conta   3 - Sair\n");
    response = input.nextInt();

    if (response == 1) {
      String email;
      String password;

      System.out.println("\nMuito bem, digite seu e-mail e sua senha.\n");
      email = input.next();
      password = input.next();

      if (accountListing.thisAccountExists(email, password))
        dashboard();

      else {
        System.out.println(
            "\nDesculpe, mas não encontramos sua conta. Verifique seus dados e tente novamente.\n");
        login();
      }
    }

    if (response == 2)
      register();

    if (response == 3) {
      accountListing.writeListAccounts();
      System.exit(0);
    }

    else {
      System.out.println("\nInsira um comando válido.\n");
      login();
    }

    input.close();

  }

  /**
   * O método register serve somente para instanciar uma nova conta no sistema.
   */

  public static void register() {
    Scanner input = new Scanner(System.in);

    String name;
    String email;
    String password;

    System.out.println("\nOk, Vamos cadastrar a sua conta. Digite seu nome, e-mail e senha.\n");
    name = input.next();
    email = input.next();
    password = input.next();

    accountListing.addObject(new Account(name, email, password));

    login();

    input.close();
  }

  /**
   * Aqui é onde as funcionalidades do sistema aparecem, onde é possível fazer
   * toda a gestão do mercantil.
   */

  public static void dashboard() {
    Scanner input = new Scanner(System.in);
    int response;

    System.out.println("\nBem-vindo ao nosso sistema, aproveite nossas funcionalidades!\n");
    System.out.println(
        "\n1 - Gestão de funcionários   2 - Realizar venda   3 - Acessar contas   4 - Estoque   5 - Registros   6 - Sair\n");
    response = input.nextInt();

    if (response == 1) {
      System.out.println("\n" + employeeListing + "\n");

      System.out.println("O que deseja fazer?\n");
      System.out.println(
          "\n1 - Cadastrar funcionário   2 - Remover funcionário   3 - Atualizar funcionário   4 - Voltar\n");
      response = input.nextInt();

      if (response == 1) {
        String name;
        String cpf;
        String contact;
        double wage;
        TypeEmployee office;

        System.out.println("\nOk. Informe o nome, CPF, contato, salário e cargo do novo funcionário.\n");
        name = input.next();
        cpf = input.next();
        contact = input.next();
        wage = input.nextDouble();
        office = TypeEmployee.COMMON_EMPLOYEE;

        employeeListing.addObject(new Employee(name, cpf, contact, wage, office));
        employeeListing.writeListEmployess();
        dashboard();
      }
      if (response == 2) {
        System.out.println("\nOk. Informe o ID do funcionário que você deseja remover.\n");
        response = input.nextInt();

        employeeListing.deleteObject(response);
        employeeListing.writeListEmployess();
        dashboard();
      }
      if (response == 3) {
        int idEmployee;
        System.out.println("\nOk. Informe o ID do funcionário que você deseja atualizar.\n");
        idEmployee = input.nextInt();

        System.out.println("\n1 - Atualizar contato   2 - Atualizar salário   3 - Atualizar cargo\n");
        response = input.nextInt();

        if (response == 1) {
          String newContact;
          System.out.println("\nInforme o novo contato do funcionário: \n");
          newContact = input.next();

          employeeListing.updateEmployeeContact(idEmployee, newContact);
          dashboard();
        }
        if (response == 2) {
          String newWage;
          System.out.println("\nInforme o novo salário do funcionário: \n");
          newWage = input.next();

          employeeListing.updateEmployeeContact(idEmployee, newWage);
          dashboard();
        }
        if (response == 3) {
          employeeListing.updateEmployeeOffice(idEmployee);
          dashboard();
        } else {
          System.out.println("\nDigite um comando válido.\n");
          dashboard();
        }

        employeeListing.writeListEmployess();
      }

      if (response == 4) {
        dashboard();
      }

      else {
        System.out.println("\nDigite um comando válido.\n");
        dashboard();
      }

    }

    if (response == 2) {
      String productName;
      int quantity;
      String name;
      String cpf;
      String contact;

      System.out.println("\nInsira os dados do cliente(nome, CPF e contato).\n");
      name = input.next();
      cpf = input.next();
      contact = input.next();

      Order newOrder = new Order(new ArrayList<Item>(), new Client(name, cpf, contact));

      System.out.println("\n" + stock + "\n");

      while (true) {
        System.out.println("\nEscolha um produto e sua quantidade para botar no carrinho.\n");
        productName = input.next();
        quantity = input.nextInt();

        Item newItem = new Item(Menu.stock.getProductsList().get(Menu.stock.findProductId(productName)),
            quantity);

        newOrder.addItem(newItem);

        System.out.println("\n" + newOrder.toString() + "\n");

        System.out.println("\nDeseja adicionar mais algum produto?\n");
        System.out.println("\n1 - Sim   2 - Não\n");
        response = input.nextInt();

        if (response == 2)
          break;
      }

      System.out.println("\nDeseja remover algum produto?\n");
      System.out.println("\n1 - Sim   2 - Não\n");
      response = input.nextInt();

      if (response == 1) {
        int idProduct;

        System.out.println("\nInsira o ID do produto que você deseja remover.\n");
        idProduct = input.nextInt();

        newOrder.removeItem(idProduct);

      }
      if (response == 2) {
        System.out.println("\nCompra finalizada.\n");
        Menu.report.addOrder(newOrder);

        dashboard();
      }
    }

    if (response == 3) {
      System.out.println("\n" + accountListing + "\n");

      System.out.println("\nO que deseja fazer?\n");
      System.out.println("\n1 - Cadastrar conta   2 - Remover conta   3 - Atualizar conta   4 - Voltar\n");
      response = input.nextInt();

      if (response == 1) {
        String username;
        String email;
        String password;

        System.out.println("\nOk. Informe um nome de usuário, e-mail e uma senha.\n");
        username = input.next();
        email = input.next();
        password = input.next();

        accountListing.addObject(new Account(username, email, password));

        dashboard();
      }
      if (response == 2) {
        System.out.println("\nOk. Informe o ID da conta que você deseja remover.\n");
        response = input.nextInt();

        accountListing.deleteObject(response);

        dashboard();
      }
      if (response == 3) {
        int idAccount;
        System.out.println("\nOk. Informe o ID da conta que você deseja atualizar.\n");
        idAccount = input.nextInt();

        System.out.println("\n1 - Atualizar nome   2 - Atualizar email   3 - Atualizar senha\n");
        response = input.nextInt();

        if (response == 1) {
          String newUsername;
          System.out.println("\nInforme o novo nome da conta: \n");
          newUsername = input.next();

          accountListing.updateAccountName(idAccount, newUsername);

          dashboard();
        }
        if (response == 2) {
          String newEmail;
          System.out.println("\nInforme o novo email da conta: \n");
          newEmail = input.next();

          accountListing.updateAccountEmail(idAccount, newEmail);

          dashboard();
        }
        if (response == 3) {
          String newPassword;
          System.out.println("\nInforme a nova senha da conta: \n");
          newPassword = input.next();

          accountListing.updateAccountPassword(idAccount, newPassword);

          dashboard();
        } else {
          System.out.println("\nDigite um comando válido.\n");
          dashboard();
        }
      }

      if (response == 4)
        dashboard();

    }
    if (response == 4) {
      System.out.println("\n" + stock + "\n");

      System.out.println("\nO que deseja fazer?\n");
      System.out.println(
          "\n1 - Adicionar produto   2 - Remover produto   3 - Atualizar produto   4 - Pesquisar por um produto   5 - Voltar\n");
      response = input.nextInt();

      if (response == 1) {
        String name;
        double price;
        int quantity;

        System.out
            .println("\nOk. Informe o nome, preço unitário e a quantidade do produto a ser adicionado.\n");
        name = input.next();
        price = input.nextDouble();
        quantity = input.nextInt();

        stock.addProduct(new Product(name, price, quantity));

        dashboard();
      }
      if (response == 2) {
        System.out.println("\nOk. Informe o ID do produto que você deseja remover.\n");
        response = input.nextInt();

        stock.deleteProduct(response);

        dashboard();
      }
      if (response == 3) {
        int idProduct;
        System.out.println("\nOk. Informe o ID do produto que você deseja atualizar.\n");
        idProduct = input.nextInt();

        System.out.println("\n1 - Atualizar nome   2 - Atualizar preço   3 - Atualizar quantidade\n");
        response = input.nextInt();

        if (response == 1) {
          String newName;
          System.out.println("\nInforme o novo nome do produto: \n");
          newName = input.next();

          stock.updateProductName(idProduct, newName);

          dashboard();
        }
        if (response == 2) {
          double newPrice;
          System.out.println("\nInforme o novo preço do produto: \n");
          newPrice = input.nextDouble();

          stock.updateProductPrice(idProduct, newPrice);

          dashboard();
        }
        if (response == 3) {
          int newQuantity;
          System.out.println("\nInforme a quantidade para adicionarmos ao produto: \n");
          newQuantity = input.nextInt();

          stock.updateProductQuantity(idProduct, newQuantity);

          dashboard();
        }
      }

      if (response == 4) {
        String pattern;
        System.out.println("\nDigite o nome do produto que procura: \n");
        pattern = input.next();

        stock.search(pattern);

        dashboard();

      }

      if (response == 5) {
        stock.writeListProducts();
        dashboard();
      }

      else {
        System.out.println("\nDigite um comando válido.\n");
        dashboard();
      }

    }
    if (response == 5) {
      System.out.println("\n" + report + "\n");

      System.out.println("\n1 - Voltar\n");
      response = input.nextInt();

      if (response == 1)
        dashboard();

      else {
        System.out.println("\nInsira um comando válido.\n");
        dashboard();
      }
    }
    if (response == 6)
      login();

    else {
      System.out.println("\nInsira um comando válido.\n");
      dashboard();
    }

    input.close();
  }

}
