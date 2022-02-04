/**
 * Classe Employee encapsula os dados básicos que um
 * empregado deve ter em um mercantil. O mesmo herda
 * da classe abstrata Person
 */
public class Employee extends Person {

    private static int counterId = 0;
    private int id;
    private double wage;
    private TypeEmployee office;

    /**
     * Construtor para a classe Employee, que recebe os dados para
     * inicializar os campo da classe Employee
     * 
     * @param name
     * @param cpf
     * @param contact
     * @param wage
     * @param office
     * 
     * @return void
     */
    
    public Employee(String name, String cpf, String contact, double wage,
            TypeEmployee office) {
        super(name, cpf, contact); // delegando funcionalidades
        Employee.counterId++;
        this.id = counterId;
        this.wage = wage;
        this.office = office;
    }

    public int getId() { return id; }

    public double getWage() { return wage; }

    public TypeEmployee getOffice() { return office; }

    public void setWage(double wage) { this.wage = wage; }

    /**
     * @method setContact que muda o campo contato reutilzando a
     *         lógica do método setContact da classe pai
     */
    @Override
    public void setContact(String contact) {
        super.setContact(contact);
    }

    public void setOffice(TypeEmployee office) {
        this.office = office;
    }

    @Override
    public String toString() {
        return String.format("\nID: %d, %s, Salário: %.2f, Cargo: %s\n", id,
         super.toString(), wage, office);
    }

}