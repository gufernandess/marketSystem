import java.util.ArrayList;
import java.util.List;

public class AccountListing implements Listing {

    private List<Account> accountsList;

    public AccountListing(/*List<Account> list*/) {
        accountsList = new ArrayList<Account>();
        //if (list != null) accountsList.addAll(list);
    }

    /**
     * Método privado para verificação da existência de uma eventual conta para
     * cadastro.
     * Usando o email como atributo de comparação (Atributo único para cada conta).
     * 
     * @param email
     * @return boolean
     */

    private boolean verifyEmail(String email) {
        boolean verifyEmail = false;
        for (int i = 0; i < accountsList.size(); i++) {
            if (email.equals(accountsList.get(i).getEmail())) {
                verifyEmail = true;
            }
        }

        return verifyEmail;
    }

    /**
     * Esse método público é bastante semelhante ao método anterior,
     * mas ao invés de verificar a existência de uma conta, ela também
     * verifica a autenticidade dos dados do usuário na classe Menu para
     * que o usuário consiga logar no sistema.
     * 
     * @param email
     * @param password
     * @return boolean
     * 
     */

    public boolean thisAccountExists(String email, String password) {
        boolean thisAccountExists = false;
        for (int i = 0; i < accountsList.size(); i++) {
            if (email.equals(accountsList.get(i).getEmail()) && 
            password.hashCode() == accountsList.get(i).getPassword()) {
                thisAccountExists = true;
            }
        }

        return thisAccountExists;
    }

    /**
     * Método implementado do Listing, é feito o casting para um objeto do tipo
     * Account.
     * Assim é feito a verificação da existência da conta, e depois o seu cadastro.
     * 
     * @param Object
     * @return boolean
     */

    @Override
    public boolean addObject(Object account) {
        if (verifyEmail(((Account) account).getEmail())) {
            System.out.println("\nParece que você já tem uma conta cadastrada no nosso sistema, tente logar.\n");
            return false;
        } else {
            accountsList.add(((Account) account));
            System.out.println("\nConta cadastrada com sucesso!\n");
            return true;
        }
    }

    @Override
    public boolean deleteObject(int idAccount) {
        if (accountsList.get(idAccount) != null) {
            accountsList.remove(accountsList.get(idAccount));
            System.out.println("\nConta deletada com sucesso!\n");
            return true;
        } else {
            System.out.println("\nEsta conta não foi encontrada no sistema.\n");
            return false;
        }
    }

    public boolean updateAccountName(int idAccount, String newName) {
        if (accountsList.get(idAccount) != null) {
            accountsList.get(idAccount).setUsername(newName);
            System.out.println("\nNome de usuário atualizado!\n");
            return true;
        } else {
            System.out.println("\nEsta conta não foi encontrada no sistema.\n");
            return false;
        }
    }

    public boolean updateAccountEmail(int idAccount, String newEmail) {
        if (accountsList.get(idAccount) != null) {
            if (verifyEmail(newEmail) == false) {
                accountsList.get(idAccount).setUsername(newEmail);
                System.out.println("\nE-mail atualizado!\n");
                return true;
            } else {
                System.out.println("\nEste email já está cadastrado no nosso sistema.\n");
                return false;
            }
        } else {
            System.out.println("\nEsta conta não foi encontrada no sistema.\n");
            return false;
        }
    }

    public boolean updateAccountPassword(int idAccount, String newPassword) {
        if (accountsList.get(idAccount) != null) {
            accountsList.get(idAccount).setPassword(newPassword);
            System.out.println("\nSenha atualizada!\n");
            return true;
        } else {
            System.out.println("\nEsta conta não foi encontrada no sistema.\n");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder accounts = new StringBuilder();

        System.out.println("\n----------CONTAS----------");
        System.out.println("\nID | Nome | Email | Senha\n");

        for (int i = 0; i < accountsList.size(); i++) {
            accounts.append(accountsList.get(i).getId() + " | ");
            accounts.append(accountsList.get(i).getUsername() + " | ");
            accounts.append(accountsList.get(i).getEmail() + " | ");
            accounts.append(accountsList.get(i).getPassword() + "\n");
        }

        return accounts.toString();
    }
}