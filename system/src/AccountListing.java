import java.util.ArrayList;
import java.util.List;

public class AccountListing implements Listing {

    private List<Account> accountsList;

    public AccountListing(List<Account> list) {
        accountsList = new ArrayList<Account>();
        if(list != null) accountsList.addAll(list);
    }

    /**
     * Método privado para verificação da existência de uma eventual conta para cadastro.
     * Usando o email como atributo de comparação (Atributo único para cada conta).
     * 
     * @param email
     * @return boolean
     */

    private boolean accountAlreadyExists(String email) {
        boolean accountAlreadyExists = false;
        for (int i = 0; i < accountsList.size(); i++) {
            if (email.equals(accountsList.get(i).getEmail())) {
                accountAlreadyExists = true;
            }
        }

        return accountAlreadyExists;
    }

    /**
     * Método privado para achar conta baseado no seu id.
     * Usado para modificações na conta (Deletar/Atualizar).
     * 
     * @param id
     * @return Account
     */

    private Account findAccountById(int id) {
        int idAccount = -1;
        for(int i = 0; i < accountsList.size(); i++) {
            if(id == accountsList.get(i).getId()) {
                idAccount = i;
            }
        }

        return idAccount != -1 ? accountsList.get(idAccount) : null;
    }

    /**
     * Método implementado do Listing, é feito o casting para um objeto do tipo Account.
     * Assim é feito a verificação da existência da conta, e depois o seu cadastro.
     * 
     * @param Object
     * @return boolean
     */

    @Override
    public boolean addObject(Object account) {
        if(accountAlreadyExists(((Account) account).getEmail())) {
            System.out.println("Parece que você já tem uma conta cadastrada no nosso sistema, tente logar.\n");
            return false;
        } else {
            accountsList.add(((Account) account));
            return true;
        }
    }

    @Override
    public boolean deleteObject(int idAccount) {
        if(findAccountById(idAccount) != null) {
            accountsList.remove(accountsList.get(idAccount));
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateAccountName(int idAccount, String newName) {
        if (findAccountById(idAccount) != null) {
            findAccountById(idAccount).setUsername(newName);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateAccountEmail(int idAccount, String newEmail) {
        if (findAccountById(idAccount) != null && accountAlreadyExists(newEmail) == false) {
            findAccountById(idAccount).setUsername(newEmail);
            return true;
        } else {
            System.out.println("Este email já está cadastrado no nosso sistema.\n");
            return false;
        }
    }

    public boolean updateAccountPassword(int idAccount, String newPassword) {
        if (findAccountById(idAccount) != null) {
            findAccountById(idAccount).setPassword(newPassword);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder accounts = new StringBuilder();

        System.out.println("----------CONTAS----------");
        System.out.println("\nID | Nome | Email | Senha");

        for (int i = 0; i < accountsList.size(); i++) {
            accounts.append(accountsList.get(i).getId() + " | ");
            accounts.append(accountsList.get(i).getUsername() + " | ");
            accounts.append(accountsList.get(i).getEmail() + " | ");
            accounts.append(accountsList.get(i).getPassword() + "\n");
        }

        return accounts.toString();
    }
}