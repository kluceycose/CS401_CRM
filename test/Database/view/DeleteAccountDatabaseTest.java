package Database.view;

import Accounts.model.Account;
import Accounts.model.AccountList;
import Contact.model.Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kenny
 */
public class DeleteAccountDatabaseTest {

    private static final String URL = "jdbc:derby://localhost:1527/Test;create=true";
    AccountList accountList;
    Calendar closeDate;
    Account testAccount;
    Contact testContact;

    public DeleteAccountDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        CreateDatabase createDatabase = new CreateDatabase(URL);
        createDatabase.execute();
    }

    @AfterClass
    public static void tearDownClass() {
        try (Connection connect = DriverManager.getConnection(URL); Statement stat = connect.createStatement()) {

            stat.executeUpdate("DROP TABLE Works_For");
            stat.executeUpdate("DROP TABLE Account");
            stat.executeUpdate("DROP TABLE Contact");

        } catch (SQLException ex) {
            Logger.getLogger(AddAccountsToDatabaseTest.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    @Before
    public void setUp() {
        accountList = new AccountList();
        closeDate = new GregorianCalendar(1970, 2, 1);
        testAccount = new Account(12345, 50000, closeDate, "Test Inc");
        testContact = new Contact("Test Name", "Test@gmail.com", "555-555-5555");
        testAccount.addContact(testContact);
        accountList.addAccount(testAccount);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class DeleteAccountDatabase.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        DeleteAccountDatabase instance = new DeleteAccountDatabase(testAccount.getAccountId(), URL);
        instance.delete();

        try (Connection connect = DriverManager.getConnection(URL);
                Statement stat = connect.createStatement()) {

            ResultSet res = stat.executeQuery("SELECT " + testAccount.getAccountId()
                    + " FROM APP.ACCOUNT");

            if (res.next()) {
                fail("Account is still in table.");
            } else {
                System.out.println("Account was deleted.");
                assert true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
