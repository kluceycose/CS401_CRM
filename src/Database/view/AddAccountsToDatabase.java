package Database.view;

import Accounts.model.Account;
import Accounts.model.AccountList;
import Contact.model.Contact;
import Contact.model.ContactsList;
import Menu.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kenny
 *
 * Inserts new accounts and contacts into ACCOUNT and CONTACT Tables of Database
 */
public class AddAccountsToDatabase implements MenuItem {

    // URL to where database is created
    private String URL;
    private final AccountList accountList;

    // Constructor takes current AccountList and sets default URL
    public AddAccountsToDatabase(AccountList accountList) {
        this.accountList = accountList;
        URL = "jdbc:derby://localhost:1527/CRM";
    }

    // Constructor takes current AccountList and URL
    public AddAccountsToDatabase(AccountList accountList, String URL) {
        this.accountList = accountList;
        this.URL = URL;
    }

    // Loads Apache Derby driver and called insert() to insert data to database
    @Override
    public void execute() {

        try {
            // Load Derby's network client driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        insert();
    }

    // Inserts account and contacts into associated tables
    // Pre: Database and Tables for ACCOUNT and CONTACT must be setup
    // Post: New Accounts and Contacts from current session added to tables
    private void insert() {
        // Establish connection to given database URL
        try (Connection connect = DriverManager.getConnection(URL);) {

            for (Account account : accountList.getList()) {
                int accountId = account.getAccountId();

                // Check if account exists in table
                String checkRecordExists = "SELECT accountId FROM ACCOUNT "
                        + "WHERE accountId=" + Integer.toString(accountId);
                PreparedStatement ps = connect.prepareStatement(checkRecordExists);
                ResultSet res = ps.executeQuery();

                // If it does not exist then insert account
                if (!(res.next())) {
                    int amount = account.getAmount();

                  // Convert closeDate to milliseconds
                    int closeDate = (int) account.getCloseDate().getTimeInMillis();
                    String accountName = account.getAccountName();
                    ContactsList contactsList = account.getContactsList();

                    String insertAccount = "INSERT INTO ACCOUNT VALUES (?, ?, ?, ?)";
                    ps = connect.prepareStatement(insertAccount);
                    ps.setInt(1, accountId);
                    ps.setInt(2, amount);
                    ps.setLong(3, closeDate);
                    ps.setString(4, accountName);
                    ps.executeUpdate();

                    // Insert contacts into Contact table
                    for (Contact contact : contactsList.getContactsList()) {
                        String name = contact.getName();
                        String email = contact.getEmail();
                        String phoneNumber = contact.getPhoneNumber();
                        String insertContacts = "INSERT INTO CONTACT VALUES (?, ?, ?)";
                        ps = connect.prepareStatement(insertContacts);

                        ps.setString(1, name);
                        ps.setString(2, email);
                        ps.setString(3, phoneNumber);
                        ps.executeUpdate();

                        // Insert relation between Account and Contacts
                        String insertWorksFor = "INSERT INTO WORKS_FOR VALUES (?, ?)";
                        ps = connect.prepareStatement(insertWorksFor);

                        ps.setString(1, email);
                        ps.setInt(2, accountId);
                    }

                }
            }

            // Close connection
            connect.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Add Accounts to Database";
    }

    // Getters and Setters
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public AccountList getAccountList() {
        return accountList;
    }

    // Sets URL to default
    public void defaultURL() {
        setURL("jdbc:derby://localhost:1527/CRM");
    }
}
