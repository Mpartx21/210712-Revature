package dao;

import java.sql.SQLException;

public class UserDAOFactory {
    private static UserDAO userDAO;

    private UserDAOFactory(){}

    public static UserDAO getUserDAO() throws SQLException{
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
}