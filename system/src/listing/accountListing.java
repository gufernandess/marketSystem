package listing;
import java.util.List;

import Account;

public class accountListing {

    private List<Account> accountsList;

    public accountListing(List list) {}

    public boolean addAccount(Account account) {}

    public boolean deleteAccount(int index) {}

    private Account findAccountById(int id) {}

    public boolean updateAccountName(String name, String newName) {}

    public boolean updateAccountPassword(String name, String newPassword) {}

    public String toString() {}
}