import java.util.ArrayList;
import java.util.List;

public class EmployeeListing implements Listing {

    private List<Employee> employeesList;

    public EmployeeListing(List<Employee> list) {
        employeesList = new ArrayList<Employee>(50);
        if (list != null)
            employeesList.addAll(list);
    }

    private boolean employeeAlreadyExists(String cpf) {
        boolean employeeAlreadyExists = false;
        for (int i = 0; i < employeesList.size(); i++) {
            if (cpf.equals(employeesList.get(i).getCpf())) {
                employeeAlreadyExists = true;
            }
        }

        return employeeAlreadyExists;
    }

    @Override
    public boolean addObject(Object employee) {
        if (employeeAlreadyExists(((Employee) employee).getCpf())) {
            System.out.println("Parece que este funcionário já está cadastrado no sistema.\n");
            return false;
        } else {
            employeesList.add(((Employee) employee));
            return true;
        }
    }

    @Override
    public boolean deleteObject(Object employee) {
        if (employeeAlreadyExists(((Employee) employee).getCpf())) {
            employeesList.remove(((Employee) employee));
            return true;
        } else {
            System.out.println("Funcionário não encontrado.\n");
            return false;
        }
    }

    public boolean updateEmployeeWage(Employee employee, double newWage) {
        if (employeeAlreadyExists(employee.getCpf())) {
            employee.setWage(newWage);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateEmployeeContact(Employee employee, String newContact) {
        if (employeeAlreadyExists(employee.getCpf())) {
            employee.setContact(newContact);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder employees = new StringBuilder();

        System.out.println("----------FUNCIONÁRIOS----------");
        System.out.println("\nID | Nome | CPF | Contato | Salário | Cargo");

        for (int i = 0; i < employeesList.size(); i++) {
            employees.append(i + " | ");
            employees.append(employeesList.get(i).getName() + " | ");
            employees.append(employeesList.get(i).getCpf() + " | ");
            employees.append(employeesList.get(i).getContact() + " | ");
            employees.append(employeesList.get(i).getWage() + "\n");
            employees.append(employeesList.get(i).getTypeEmployee() + "\n");
        }

        return employees.toString();
    }
}
