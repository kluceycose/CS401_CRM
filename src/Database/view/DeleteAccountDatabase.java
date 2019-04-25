package Database.view;

import Menu.MenuItem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author kenny Deletes account from database using a given account name.
 */
public class DeleteAccountDatabase implements MenuItem {

    // URL to where database is created
    private String URL;
    private int accountId;

    // Constructor sets default URL and accepts accountId
    public DeleteAccountDatabase(int accountId) {
        this.URL = "jdbc:derby://localhost:1527/CRM";
        this.accountId = accountId;
    }

    // Constructor accepts accountId and URL
    public DeleteAccountDatabase(int accountId, String URL) {
        this.URL = URL;
        this.accountId = accountId;
    }

    @Override
    public void execute() {

        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter accountId to delete: ");
        setAccountId(userinput.nextInt());

        delete();
    }

    public void delete() {
        try {
            // Load Derby's network client driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establish connection to given database URL
        try (Connection connect = DriverManager.getConnection(URL);) {

            String deleteString = "DELETE FROM Account WHERE accountID="
                    + this.accountId;
            PreparedStatement ps = connect.prepareStatement(deleteString);
            ps.executeUpdate();

            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Delete Account from Database";
    }

}
