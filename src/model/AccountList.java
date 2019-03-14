package model;

/**
 *
 * @author kluceycose
 */

import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accounts;

    //Constructor
    public AccountList() {
        accounts = new ArrayList<>();
    }

    //Setter
    public void addAccount(Account account) {
        accounts.add(account);
    }

    //Getters
    public Account getAccount(int accountNum){
        return accounts.get(accountNum);
    }
    public List<Account> getList(){
        return accounts;
    }
}
