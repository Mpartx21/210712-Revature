package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    public AccountDAOImpl() {
        this.connection = ConnectionFac
    }

    @Override
    public void addAccount(Account account) throws SQLException {

    }

    @Override
    public void updateAccount(Account account) throws SQLException {

    }

    @Override
    public void deleteAccount(int id) throws SQLException {

    }

    @Override
    public List<Account> getAccount() throws SQLException {
        return null;
    }

    @Override
    public Account accountByID(int id) throws SQLException {
        return null;
    }
}
