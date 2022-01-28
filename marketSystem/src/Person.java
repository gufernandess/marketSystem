public abstract class Person {

  private String name;
  private String cpf;
  private int contact;

  public String getName() {
    return name;
  }

  public int getContact() {
    return contact;
  }

  public String getCpf() {
    return cpf;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setContact(int contact) {
    this.contact = contact;
  }

}