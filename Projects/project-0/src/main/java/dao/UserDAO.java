package dao;


import models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void addUser(User User) throws SQLException;
    void updateUser(User User) throws SQLException;
    void deleteUser(int id) throws SQLException;
    List<User> getUser() throws SQLException;
    User userByID(int id) throws SQLException;
}
