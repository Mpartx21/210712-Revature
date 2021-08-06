package com.miguel;

import java.sql.SQLException;

public class EmployeeDAOFactory {
    private static EmployeeDAO dao;

    private EmployeeDAOFactory(){ }

    public static EmployeeDAO getDao() throws SQLException {
        if(dao == null){
            dao = new EmployeeDAOImpl();
        }
        return dao;
    }

}
