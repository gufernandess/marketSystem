import java.util.ArrayList;
import java.util.List;

public class AccountListing implements Listing {

    private List<Account> accountsList;

    public AccountListing(List<Account> list) {
        accountsList = new ArrayList<Account>(50);
        if (list != null)
            accountsList.addAll(list);
    }

    private boolean accountAlreadyExists(String email) {
        boolean accountAlreadyExists = false;
        for (int i = 0; i < accountsList.size(); i++) {
            if (email.equals(accountsList.get(i).getEmail())) {
                accountAlreadyExists = true;
            }
        }

        return accountAlreadyExists;
    }

    @Override
    public boolean addObject(Object account) {
        if (accountAlreadyExists(((Account) account).getEmail())) {
            System.out.println("Parece que você já tem uma conta cadastrada no nosso sistema, tente logar.\n");
            return false;
        } else {
            accountsList.add(((Account) account));
            return true;
        }
    }

    @Override
    public boolean deleteObject(Object account) {
        if (accountAlreadyExists(((Account) account).getEmail())) {
            accountsList.remove(((Account) account));
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
            account.setPassword(newPassword);
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