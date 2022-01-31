import java.util.ArrayList;
import java.util.List;

public class employeeListing implements Listing {

    private List<Employee> employeesList = new ArrayList<Employee>(50);

    public employeeListing(List list) {
        this.employeesList = list;
    }

    private boolean employeeAlreadyExists(String cpf) {
        boolean employeeAlreadyExists = false;
        for(int i = 0; i < employeesList.size(); i++) {
            if(cpf == employeesList.get(i).getCpf()) {
                employeeAlreadyExists = true;
            }
        }

        return employeeAlreadyExists;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if(employeeAlreadyExists(employee.getCpf())) {
            System.out.println("Parece que este funcionário já está cadastrado no sistema.\n");
            return false;
        } else {
            employeesList.add(employee);
            return true;
        }
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        if(employeeAlreadyExists(employee.getCpf())) {
            employeesList.remove(employee);
            return true;
        } else {
            System.out.println("Funcionário não encontrado.\n");
            return false;
        }
    }

    public boolean updateEmployeeWage(Employee employee, double newWage) {
        if(employeeAlreadyExists(employee.getCpf())) {
            employee.setWage(newWage);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateEmployeeContact(Employee employee, int newContact) {
        if(employeeAlreadyExists(employee.getCpf())) {
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

        for(int i = 0; i < employeesList.size(); i++) {
            employees.append(i + " | ");
            employees.append(employeesList.get(i).getName() + " | ");
            employees.append(employeesList.get(i).getCpf() + " | ");
            employees.append(employeesList.get(i).getContact() + " | ");
            employees.append(employeesList.get(i).getWage() + "\n");
            // employees.append(employeesList.get(i).getOffice() + "\n");
        }

        return employees.toString();
    }
    }
}