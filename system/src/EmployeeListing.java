import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListing implements Listing {

    private List<Employee> employeesList;

    public EmployeeListing() {
        employeesList = new ArrayList<Employee>();
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
        if (employeesList.get(idEmployee - 1) != null) {
            employeesList.remove(employeesList.get(idEmployee - 1));
            System.out.println("\nFuncionário deletado!\n");
            return true;
        } else {
            System.out.println("\nFuncionário não encontrado.\n");
            return false;
        }
    }

    public boolean updateEmployeeWage(int idEmployee, double newWage) {
        if (employeesList.get(idEmployee - 1) != null) {
            employeesList.get(idEmployee - 1).setWage(newWage);
            System.out.println("\nSalário atualizado!\n");
            return true;
        } else {
            System.out.println("\nEste funcionário não foi encontrado no sistema.\n");
            return false;
        }
    }

    public boolean updateEmployeeContact(int idEmployee, String newContact) {
        if (employeesList.get(idEmployee - 1) != null) {
            if (employeeAlreadyExists(newContact) == false) {
                employeesList.get(idEmployee - 1).setContact(newContact);
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
        if (employeesList.get(idEmployee - 1).getOffice() == TypeEmployee.COMMON_EMPLOYEE) {
            employeesList.get(idEmployee - 1).setOffice(TypeEmployee.MANAGER);
            System.out.println("\nCargo atualizado!\n");
            return true;
        } else {
            employeesList.get(idEmployee - 1).setOffice(TypeEmployee.COMMON_EMPLOYEE);
            System.out.println("\nCargo atualizado!\n");
            return true;
        }
    }

    /**
     * Salvando e lendo dados no arquivo
     */

    public void readListEmployess() {
        Employee employee;
        boolean endOfFile = false;

        try (
                FileInputStream employeeFile = new FileInputStream("Employess.txt");
                ObjectInputStream employeeStream = new ObjectInputStream(employeeFile);) {

            while (endOfFile == false) {
                try {
                    employee = (Employee) employeeStream.readObject();
                    employeesList.add(employee);
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nNenhum arquivo anterior foi lido");
        } catch (ClassNotFoundException e) {
            System.out.println("\nTentando ler um objeto de uma classe desconhecida");
        } catch (StreamCorruptedException e) {
            System.out.println("\nFormato de arquivo ilegível");
        } catch (IOException e) {
            System.out.println("\nerro: Ocorreu um problema ao ler o arquivo");
        }
    }

    public void writeListEmployess() {
        try (
                FileOutputStream employeeFile = new FileOutputStream("Employess.txt");
                ObjectOutputStream employeeStream = new ObjectOutputStream(employeeFile);) {
            for (Employee employee : employeesList) {
                employeeStream.writeObject(employee);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um problema ao gravar o arquivo");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder employees = new StringBuilder();

        System.out.println("\n----------FUNCIONÁRIOS----------");
        System.out.println("\nID | Nome | CPF | Contato | Salário | Cargo\n");

        for (Employee employee : employeesList) {
            employees.append(employee.getId() + " | " + employee.getName()
                    + " | " + employee.getCpf() + " | " + employee.getContact()
                    + " | " + employee.getWage() + " | " + employee.getOffice() + "\n");

        }

        return employees.toString();
    }
}
