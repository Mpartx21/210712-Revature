package com.example.Springmicroservices.repo;

import com.example.Springmicroservices.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepo extends JpaRepository<Department,Long> {
}
