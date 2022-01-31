/**
 * A classe Employee, que encapsula os dados básicos de um empegado
 * de um mercantil. Esta classe herda da classe Person
 */
public class Employee extends Person {

    private int counterId = 0;
    private int id;
    private double wage;
    private Account account;
    private TypeEmployee typeEmployee;

    /**
     * Construtor para a classe Employee, que recebe os dados para
     * inicializar os campo da classe Employe
     * 
     * @param name
     * @param cpf
     * @param contact
     * @param wage
     * @param isManager
     * 
     * @return void
     */
    public Employee(String name, String cpf, int contact, double wage,
            TypeEmployee typeEmployee, String username, String email, String password) {
        super(name, cpf, contact); // delegando funcionalidades
        this.wage = wage;
        this.typeEmployee = typeEmployee;
        this.counterId++;
        this.id = counterId;
        this.account = new Account(username, email, password); // iniciando conta
    }

    /**
     * Geters e Seters
     */

    public int getId() {
        return id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    /**
     * @method setContact que muda o campo contato reutilzando a
     *         lógica do método setContact da classe pai
     */
    @Override
    public void setContact(int contact) {
        super.setContact(contact);
    }

    @Override
    public String toString() {
        return String.format("[%d, %.2f, %s, %s]", id, wage, account, typeEmployee);
    }
}