public class Client extends Person {

    public Client(String name, String cpf, String contact) {
        super(name, cpf, contact);
    }

    public String toString() {
        return String.format("Nome: %s, CPF: %s, Contato: %s", super.toString());
    }
}