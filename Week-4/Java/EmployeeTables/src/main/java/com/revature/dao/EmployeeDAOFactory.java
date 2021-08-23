package com.revature.dao;

public class EmployeeDAOFactory {
	private static EmployeeDAO dao;

		private EmployeeDAOFactory() {}
		
		public static EmployeeDAO getDAO() {
			if(dao == null) {
				dao = new EmployeeDAOImpl();
			}
			return dao;
		}
}
