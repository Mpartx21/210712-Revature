package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String url = "jdbc:mysql://localhost:3306/revature";
    private final String userName ="root";
    private final String passWord = "password";

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();

    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection getConnection(){
        Connection  connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,userName,passWord);

        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}
