public class Client extends Person {

    public Client(String name, String cpf, String contact) {
        super(name, cpf, contact);
    }

    public String toString() {
        return String.format("\n\nNome: %s, CPF: %s, Contato: %s\n\n", super.toString());
    }
}