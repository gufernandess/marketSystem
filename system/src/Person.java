public abstract class Person {

  private String name;
  private String cpf;
  private int contact;

  public Person(String name, String cpf, int contact) {
    this.name = name;
    this.cpf = cpf;
    this.contact = contact;
  }

  public String getName() {
    return name;
  }

  public int getContact() {
    return contact;
  }

  public String getCpf() {
    return cpf;
  }

  public void setContact(int contact) {
    this.contact = contact;
  }

}