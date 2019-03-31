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
public class AddAccountsToDatabaseTest {

    private static final String URL = "jdbc:derby://localhost:1527/Test;create=true";
    AccountList accountList;
    Calendar closeDate;
    Account testAccount;
    Contact testContact;

    public AddAccountsToDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        CreateDatabase createDatabase = new CreateDatabase(URL);
        createDatabase.execute();
    }

    @AfterClass
    public static void tearDownClass() {
         try (Connection connect = DriverManager.getConnection(URL); Statement
         stat = connect.createStatement()) {
         
         stat.executeUpdate("DROP TABLE Works_For");
         stat.executeUpdate("DROP TABLE Account");
         stat.executeUpdate("DROP TABLE Contact");
         
         } catch (SQLException ex) {
         Logger.getLogger(AddAccountsToDatabaseTest.class.getName()).log(Level.SEVERE,
         null, ex); }
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
     * Test of execute method, of class AddAccountsToDatabase.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddAccountsToDatabase instance = null;

        instance = new AddAccountsToDatabase(accountList, URL);
        instance.execute();

        try (Connection connect = DriverManager.getConnection(URL);
                Statement stat = connect.createStatement()) {

            ResultSet res = stat.executeQuery("SELECT * FROM APP.ACCOUNT");

            int accountId = 0;
            while (res.next()) {
                accountId = res.getInt("accountId");
            }

            assertEquals(12345, accountId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
