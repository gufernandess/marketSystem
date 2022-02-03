import java.util.ArrayList;
import java.util.List;
public class EmployeeListing implements Listing {

    private List<Employee> employeesList;

    public EmployeeListing(/*List<Employee> list*/) {
        employeesList = new ArrayList<Employee>();
        //if (list != null) employeesList.addAll(list);
    }

    /**
     * Método privado para verificação da existência de um funcionário na lista.
     * Usando o CPF como atributo de comparação (Atributo único para cada
     * funcionário).
     * 
     * @param cpf
     * @return boolean
     */

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
            System.out.println("\nParece que este funcionário já está cadastrado no sistema.\n");
            return false;
        } else {
            employeesList.add(((Employee) employee));
            System.out.println("\nFuncionário cadastrado!\n");
            return true;
        }
    }

    @Override
    public boolean deleteObject(int idEmployee) {
        if (employeesList.get(idEmployee) != null) {
            employeesList.remove(employeesList.get(idEmployee));
            System.out.println("\nFuncionário deletado!\n");
            return true;
        } else {
            System.out.println("\nFuncionário não encontrado.\n");
            return false;
        }
    }

    public boolean updateEmployeeWage(int idEmployee, double newWage) {
        if (employeesList.get(idEmployee) != null) {
            employeesList.get(idEmployee).setWage(newWage);
            System.out.println("\nSalário atualizado!\n");
            return true;
        } else {
            System.out.println("\nEste funcionário não foi encontrado no sistema.\n");
            return false;
        }
    }

    public boolean updateEmployeeContact(int idEmployee, String newContact) {
        if (employeesList.get(idEmployee) != null) {
            if (employeeAlreadyExists(newContact) == false) {
                employeesList.get(idEmployee).setContact(newContact);
                System.out.println("\nContato atualizado!\n");
                return true;
            } else {
                System.out.println("\nEste contato já está cadastrado no nosso sistema.\n");
                return false;
            }
        } else {
            System.out.println("\nEste funcionário não foi encontrado no sistema.\n");
            return false;
        }
    }

    public boolean updateEmployeeOffice(int idEmployee) {
        if(employeesList.get(idEmployee).getOffice() == TypeEmployee.COMMON_EMPLOYEE) {
            employeesList.get(idEmployee).setOffice(TypeEmployee.MANAGER);
            System.out.println("\nCargo atualizado!\n");
            return true;
        }
        else {
            employeesList.get(idEmployee).setOffice(TypeEmployee.COMMON_EMPLOYEE);
            System.out.println("\nCargo atualizado!\n");
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder employees = new StringBuilder();

        System.out.println("\n----------FUNCIONÁRIOS----------");
        System.out.println("\nID | Nome | CPF | Contato | Salário | Cargo\n");

        for (int i = 0; i < employeesList.size(); i++) {
            employees.append(employeesList.get(i).getId() + " | ");
            employees.append(employeesList.get(i).getName() + " | ");
            employees.append(employeesList.get(i).getCpf() + " | ");
            employees.append(employeesList.get(i).getContact() + " | ");
            employees.append(employeesList.get(i).getWage() + " | ");
            employees.append(employeesList.get(i).getOffice() + "\n");
        }

        return employees.toString();
    }
}
