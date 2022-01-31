public class Client extends Person {

    public Client(String name, String cpf, String contact) {
        super(name, cpf, contact);
    }

    public String toString() {
        return String.format("[%s, %s, %s]", super.toString());
    }
}