public class Employee {

    private final int counterId = 0;
    private int id;
    private double wage;
    private Account account;
    private boolean isManager;

    public Employee(String name, String cpf, int contact, double wage, boolean isManager) {}

    public int getId() {
        return id;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    setContact(int contact) {
        this.contact = contact;
    }

    public String toString() {}
}