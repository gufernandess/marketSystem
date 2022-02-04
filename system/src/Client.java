/**
 * Classe Client encapsula os dados básicos de um
 * cliente em um mercantil. A mesma herda da classe
 * Person
 */
public class Client extends Person {

    /**
     * Construtor da classe Client recebe os dados básicos para
     * inicializar os atributos de Client
     * 
     * @param name
     * @param cpf
     * @param contact
     * 
     * @return void
     */
    public Client(String name, String cpf, String contact) {
        super(name, cpf, contact);
    }

    public String toString() {
        return String.format("\nNome: %s, CPF: %s, Contato: %s\n", super.getName(),
                super.getCpf(), super.getContact());
    }
}