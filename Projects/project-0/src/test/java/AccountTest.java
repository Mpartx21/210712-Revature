import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOFactory;
import com.revature.models.Account;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class AccountTest {
    AccountDAO accountDAO = null;

    @Before
    public void setUp(){
        try{
        accountDAO = AccountDAOFactory.getAccountDAO();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void getAccountsTest() throws SQLException {
        List<Account> actual = accountDAO.getAllAccounts();
        assertEquals(actual.toString(),accountDAO.getAllAccounts().toString());
    }

    @Test
    public void getAccountByAccountIDTest() throws SQLException{
        Account actual = accountDAO.getAccountbyAccountId(2);
        assertNotEquals(actual.toString(),accountDAO.getAccountbyAccountId(3).toString());
    }



}
