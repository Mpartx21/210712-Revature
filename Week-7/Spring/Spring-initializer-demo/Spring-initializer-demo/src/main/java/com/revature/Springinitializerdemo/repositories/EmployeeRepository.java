package com.revature.Springinitializerdemo.repositories;

import com.revature.Springinitializerdemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value="",nativeQuery = true)
public Employee findByEmployeeName (String employeeName);
public Employee findByEmployeeNameIgnoreCase(String employeeName);
}
