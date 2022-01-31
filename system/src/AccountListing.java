import java.util.ArrayList;
import java.util.List;

public class AccountListing implements Listing {

    private List<Account> accountsList = new ArrayList<Account>(50);

    /**
     * Por que não iniailizar a list com o new no construtor,
     * né pra isso que ele serve?
     * Ademais, é obrigatório passar um arguemnto pro construtor?
     * E se eu passar null
     * não vai so exitir uma Lista de Contas? nem era pra ter construtor
     * 
     */

    // poderia ser assim
    /*
     * public AccountListing(List<Account> list) {
     * accountsList = new ArrayList<Account>(50);
     * if(list != null) accountList.addAll(list);
     * }
     */
    public AccountListing(List<Account> list) {
        this.accountsList = list;
    }

    /**
     * Aqui tu estás comparando email por igualdade
     * o certo é usar metodo equals()
     */
    private boolean accountAlreadyExists(String email) {
        boolean accountAlreadyExists = false;
        for (int i = 0; i < accountsList.size(); i++) {
            if (email == accountsList.get(i).getEmail()) {
                accountAlreadyExists = true;
            }
        }

        return accountAlreadyExists;
    }

    @Override
    public boolean addAccount(Account account) {
        if (accountAlreadyExists(account.getEmail())) {
            System.out.println("Parece que você já tem uma conta cadastrada no nosso sistema, tente logar.\n");
            return false;
        } else {
            accountsList.add(account);
            return true;
        }
    }

    @Override
    public boolean deleteAccount(Account account) {
        if (accountAlreadyExists(account.getEmail())) {
            accountsList.remove(account);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateAccountName(Account account, String newName) {
        if (accountAlreadyExists(account.getEmail())) {
            account.setUsername(newName);
            return true;
        } else {
            System.out.println("Conta não encontrada.\n");
            return false;
        }
    }

    public boolean updateAccountPassword(Account account, String newPassword) {
        if (accountAlreadyExists(account.getEmail())) {
            account.setUsername(newPassword);
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
            accounts.append(i + " | ");
            accounts.append(accountsList.get(i).getUsername() + " | ");
            accounts.append(accountsList.get(i).getEmail() + " | ");
            accounts.append(accountsList.get(i).getPassword() + "\n");
        }

        return accounts.toString();
    }
}