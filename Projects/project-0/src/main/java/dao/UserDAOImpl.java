package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static PreparedStatement preparedStatement = null;
    private static Connection connection = null;

    public UserDAOImpl() {
        this.connection =
    }

    @Override
    public void addUser(User User) throws SQLException {

    }

    @Override
    public void updateUser(User User) throws SQLException {

    }

    @Override
    public void deleteUser(int id) throws SQLException {

    }

    @Override
    public List<User> getUser() throws SQLException {
        return null;
    }

    @Override
    public User userByID(int id) throws SQLException {
        return null;
    }
}
