import java.util.ArrayList;
import java.util.List;

public class EmployeeListing implements Listing {

    private List<Employee> employeesList;

    public EmployeeListing(List<Employee> list) {
        employeesList = new ArrayList<Employee>();
        if (list != null) employeesList.addAll(list);
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

    /**
     * Método privado para achar funcionário baseado no seu id.
     * Usado para modificações no registro (Deletar/Atualizar).
     * 
     * @param id
     * @return Employee
     */

    /*private Employee findEmployeeById(int id) {
        int idEmployee = -1;
        for (int i = 0; i < employeesList.size(); i++) {
            if (id == employeesList.get(i).getId()) {
                idEmployee = i;
            }
        }

        return idEmployee != -1 ? employeesList.get(idEmployee) : null;
    }*/

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
    public boolean deleteObject(int idEmployee) {
        if (employeesList.get(idEmployee) != null) {
            employeesList.remove(employeesList.get(idEmployee));
            return true;
        } else {
            System.out.println("Funcionário não encontrado.\n");
            return false;
        }
    }

    public boolean updateEmployeeWage(int idEmployee, double newWage) {
        if (employeesList.get(idEmployee) != null) {
            employeesList.get(idEmployee).setWage(newWage);
            return true;
        } else {
            System.out.println("Este funcionário não foi encontrado no sistema.\n");
            return false;
        }
    }

    public boolean updateEmployeeContact(int idEmployee, String newContact) {
        if (employeesList.get(idEmployee) != null) {
            if (employeeAlreadyExists(newContact) == false) {
                employeesList.get(idEmployee).setContact(newContact);
                return true;
            } else {
                System.out.println("Este contato já está cadastrado no nosso sistema.\n");
                return false;
            }
        } else {
            System.out.println("Este funcionário não foi encontrado no sistema.\n");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder employees = new StringBuilder();

        System.out.println("----------FUNCIONÁRIOS----------");
        System.out.println("\nID | Nome | CPF | Contato | Salário | Cargo");

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
