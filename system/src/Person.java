/**
 * Classe abstrata Person define atributos e métodos mínimos
 * que uma classe que implmenta uma Person deve ter
 */
public abstract class Person {

  private String name;
  private String cpf;
  private String contact;

  public Person(String name, String cpf, String contact) {
    this.name = name;
    this.cpf = cpf;
    this.contact = contact;
  }

  /**
   * GETERS/SETERS
   */

  public String getName() {
    return name;
  }

  public String getContact() {
    return contact;
  }

  public String getCpf() {
    return cpf;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  @Override
  public String toString() {
    return String.format("Nome: %s, CPF: %s, Contato: %s", name, cpf, contact);
  }

}