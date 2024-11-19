package org.example.employeereactbackend.dao;

import org.example.employeereactbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
