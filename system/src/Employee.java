public class Employee extends Person {

    private static int counterId = 0;
    private int id;
    private double wage;
    private Account account;
    private TypeEmployee typeEmployee;

    /**
     * Construtor para a classe Employee, que recebe os dados para
     * inicializar os campo da classe Employee
     * 
     * @param name
     * @param cpf
     * @param contact
     * @param wage
     * @param typeEmployee
     * 
     * @return void
     */
    public Employee(String name, String cpf, String contact, double wage,
            TypeEmployee typeEmployee, String username, String email, String password) {
        super(name, cpf, contact); // delegando funcionalidades
        this.wage = wage;
        this.typeEmployee = typeEmployee;
        Employee.counterId++;
        this.id = counterId;
        this.account = new Account(username, email, password); // iniciando conta
    }

    public int getId() {
        return id;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
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
    public void setContact(String contact) {
        super.setContact(contact);
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, %s, Salário: %.2f, Conta: %s, Cargo: %s", id, super.toString(), wage, account, typeEmployee.toString());
    }

}