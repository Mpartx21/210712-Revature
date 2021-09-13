package com.revature.withAngular.repo;

import com.revature.withAngular.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
   //Jpa Repository is basically a defualt libary for all Models
    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);

}
