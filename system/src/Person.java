/**
 * Classe abstrata Person define atributos e métodos mínimos
 * que uma classe que implementa uma Person deve ter
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
   * Getters/Setters
   */

  public String getName() { return name; }

  public String getContact() { return contact; }

  public String getCpf() { return cpf; }

  public void setContact(String contact) { this.contact = contact; }

  @Override
  public String toString() {
    return String.format("\n\nNome: %s, CPF: %s, Contato: %s\n\n", name, cpf, contact);
  }

}