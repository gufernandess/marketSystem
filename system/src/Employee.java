public class Employee extends Person {

    private final int counterId = 0;
    private int id;
    private double wage;
    private Account account;
    private boolean isManager;

    public Employee(String name, String cpf, int contact, double wage, boolean isManager) {
        super(name, cpf, contact);
        this.wage = wage;
    }

    public int getId() {
        return id;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String toString() {}
}