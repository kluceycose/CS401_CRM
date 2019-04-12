package Database.view;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class CreateDatabaseTest {

    private static final String URL = "jdbc:derby://localhost:1527/Test;create=true";

    public CreateDatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class CreateDatabase.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        CreateDatabase createDatabase = new CreateDatabase(URL);
        createDatabase.execute();

        try (Connection connect = DriverManager.getConnection(URL);
                Statement stat = connect.createStatement()) {
            
            // Get database metadata
            DatabaseMetaData meta = connect.getMetaData();
            
            // Look for table named WORKS_FOR
            ResultSet res = meta.getTables(null, null, "WORKS_FOR", null);

            stat.executeUpdate("DROP TABLE Works_For");
            stat.executeUpdate("DROP TABLE Account");
            stat.executeUpdate("DROP TABLE Contact");

            boolean exists = res.next();

            connect.close();

            assertTrue(exists);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
