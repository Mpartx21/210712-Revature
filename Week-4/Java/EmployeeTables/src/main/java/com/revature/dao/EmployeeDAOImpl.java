package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.revature.model.Employee;
import com.revature.utils.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	Session sesh = null;
	
	@Override
	public void addEmployee(Employee employee) throws SQLException {
		sesh = HibernateUtil.getSessionFactory().openSession();
		sesh.beginTransaction();
		sesh.save(employee);
		sesh.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		sesh = HibernateUtil.getSessionFactory().openSession();
		sesh.beginTransaction();
		sesh.update(employee);
		sesh.getTransaction().commit();
		HibernateUtil.shutdown();
	}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		sesh = HibernateUtil.getSessionFactory().openSession();
		sesh.beginTransaction();
		Object persistenceInstance = sesh.load(Employee.class , id);
		if(persistenceInstance != null) {
			sesh.delete(persistenceInstance);
		}
		sesh.getTransaction().commit();
		HibernateUtil.shutdown();		
	}

	@Override
	public List<Employee> getEmployess() throws SQLException, ClassNotFoundException {
		sesh = HibernateUtil.getSessionFactory().openSession();
		sesh.beginTransaction();
		List employees = sesh.createQuery("FROM Employee").list();
		sesh.getTransaction().commit();
		HibernateUtil.shutdown();
		return employees;
	}

	@Override
	public Employee employeeByID(int id) throws SQLException, ClassNotFoundException {
		sesh = HibernateUtil.getSessionFactory().openSession();
		sesh.beginTransaction();
		List employees = sesh.createQuery("FROM Employee e WHERE e.employee_id =" + id).list();
		sesh.getTransaction().commit();
		HibernateUtil.shutdown();
		return (Employee) employees.get(0);
	}

}
