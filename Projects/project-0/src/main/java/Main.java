
import utils.ProgramManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static ProgramManager programManager = new ProgramManager();

    public static void main(String[] args)  {

        while (programManager.isRunning()) {
//            programManager.
        }
    }
}


//            try {
//                Statement statement = ConnectionFactory.getInstance().getConnection().createStatement();
//
//                ResultSet resultSet = statement.executeQuery("select * from employee");
//
//                while (resultSet.next()) {
//                    System.out.println("Id: " + resultSet.getInt(1) + ", Name: "
//                            + resultSet.getString(2) + ", Email: " + resultSet.getString(3)
//                            + ", Phone: " + resultSet.getString(4));
//                }
//            } catch (Exception e) {
//
//            } finally {
//                try {
//                    ConnectionFactory.getInstance().getConnection().close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }

