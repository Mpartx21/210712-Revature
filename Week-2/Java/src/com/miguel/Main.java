package com.miguel;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static boolean running = true;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        EmployeeDAO dao = EmployeeDAOFactory.getDao();
        //        Employee employee = new Employee();
//        employee.setName("mig");
//        employee.setEmail("sdkalfj@dfjkal.com");
//
//        //Employee Dao
//        EmployeeDAO dao = EmployeeDAOFactory.getDao();
//        dao.addEmployee(employee);
//        dao.getEmployess().stream().forEach(System.out::println);
//
//        //
//        // Step 1: load the driver
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        // Step 2: Create connection Object
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/revature", "root", "password");
//
//        // Step 3: Create Statement Object
//        Statement statement = conn.createStatement();
//
//        // Step 4: Execute Query
//        ResultSet resultSet = statement.executeQuery("select * from employee");
//
//        while (resultSet.next()) {
//            System.out.println("Id: " + resultSet.getInt(1) + ", Name: "
//                    + resultSet.getString(2) + ", Email: " + resultSet.getString(3)
//                    +", Phone: "+ resultSet.getString(4));
//        }
//        // Step 5: Close the connection
//        conn.close();

        // Step 1: load the driver
        //Class.forName("com.mysql.jdbc.Driver");

        // Step 2: Create connection
//        String host = "jdbc:mysql://localhost:3306/";
//        String database = "revature";
//        // jdbc:mysql://localhost:3306/revature;
//        String connectionString = host + database;
//        String username = "root";
//        String password = "password";
//
//        Connection conn = DriverManager.getConnection(connectionString, username, password);
//
//        // Step 3: Create Statement object;
//        Statement statement = conn.createStatement();

        // Step 4: Execute Queries

        // Demo 1: Create a table
//        String query = "create table employee (id INTEGER PRIMARY KEY AUTO_INCREMENT, name CHAR(20), email CHAR(50))";
//        statement.executeUpdate(query);
//        System.out.println("table created successfully");;

        // Demo 2: Insert data into our table
//        String query = "insert into employee (name, email) values (?, ?)";
//
//        // Get PrepareStatement object
//        PreparedStatement preparedStatement =  conn.prepareStatement(query);
//        // Set the values to query
//        preparedStatement.setString(1, "Mark Smith");
//        preparedStatement.setString(2, "m@gmail.com");
//        // execute the query
//        int rowAffected = preparedStatement.executeUpdate();
//        System.out.println("("+rowAffected+") rows affected");

        // Demo 3: Update data of our table
//        String query = "update employee set name = ?, email = ? where id = ?";
//        PreparedStatement preparedStatement = conn.prepareStatement(query);
//        preparedStatement.setString(1, "Paul");
//        preparedStatement.setString(2, "p@gmail.com");
//        preparedStatement.setInt(3, 1);
//        int rowAffected = preparedStatement.executeUpdate();
//        System.out.println("("+rowAffected+") rows affected");

        // Demo 4: Delete data from our table
//        String query = "delete from employee where id = ?";
//        PreparedStatement preparedStatement = conn.prepareStatement(query);
//        preparedStatement.setInt(1, 1);
//        int rowAffected = preparedStatement.executeUpdate();
//        System.out.println("(" + rowAffected + ") rows affected");
//        Demo 5: Read the data from tabel
//        String query = "select * from employee";
//        ResultSet resultSet = statement.executeQuery(query);
//        while (resultSet.next()){
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            String email = resultSet.getString(3);
//            String phone = resultSet.getString(4);
//            System.out.println(name + " " + id + " " + email + " " + phone);
//        }
//
//
//        // Step 5: Close connection
//        if (conn.isClosed()) {
//            System.out.println("connection closed");
//        } else {
//            System.out.println("connection open");
//        }

        while (running) {
            System.out.println("case 1 : add employee\n" +
                    "case 2 : updating employee\n" +
                    "case 3 : delete employee\n" +
                    "case 4 : find employee with id\n" +
                    "case 5 : show all employees\n" +
                    "quit : will end it all");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("Adding Employee");
                    System.out.println("Add Employee Name:");
                    String employeeName = scanner.nextLine();
                    System.out.println("Add Employee Email:");
                    String employeeEmail = scanner.nextLine();
                    System.out.println("Add Employee Phone:");
                    String employeePhone = scanner.nextLine();
                    dao.addEmployee(new Employee(employeeName, employeeEmail, employeePhone));
                    System.out.println("Employee added!!!!!!!!");
                    break;
                case "2":
                    System.out.println("Updating employee\n" +
                            "Choose Employee to Update by ID");
                    int employeeID = scanner.nextInt();
                    System.out.println("Update Employee Name:");
                    employeeName = scanner.next();
                    System.out.println("Update Employee Email:");
                    employeeEmail = scanner.next();
                    System.out.println("Update Employee Phone");
                    employeePhone = scanner.next();
                    dao.updateEmployee(new Employee(employeeID, employeeName, employeeEmail, employeePhone));
                    System.out.println("Employee Updated");
                    break;
                case "3":
                    System.out.println("Deleting Employee By ID\n" +
                                       "Choose an Employee ID to Delete");
                    employeeID = scanner.nextInt();

                    dao.deleteEmployee(employeeID);

                    scanner.nextLine();
                    break;
                case "4":
                    System.out.println("Find an Employee with ID\n" +
                                       "Choose an Employee ID to Find that Employee");
                    employeeID = scanner.nextInt();
                    Employee employeeByID = dao.employeeByID(employeeID);

                    System.out.println("You found " + employeeByID.getName());

                    scanner.nextLine();
                    break;
                case "5":
                    System.out.println("All employees");
                    dao.getEmployess().stream().forEach(employee -> {
                        System.out.println("ID: " + employee.getId() +
                                "NAME: " + employee.getName());
                    });
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("What was that try again");

            }
        }
    }
}
