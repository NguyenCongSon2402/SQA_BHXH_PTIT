package Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountDBTest {

    private AccountDB accountDB;

    @Before
    public void setUp() throws Exception {
        accountDB = new AccountDB();
    }

    @After
    public void tearDown() throws Exception {
        accountDB.closeConnection();
    }

    @Test
    public void testLoginWithValidCredentials() throws Exception {
        assertTrue(accountDB.Login("son", "2402"));
    }

    @Test
    public void testLoginWithInvalidCredentials() throws Exception {
        assertFalse(accountDB.Login("invalid", "credentials"));
        assertFalse(accountDB.Login("", ""));
    }
}
