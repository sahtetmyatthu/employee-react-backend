package org.example.employeereactbackend.utils;
import org.example.employeereactbackend.dto.EmployeeDto;
import org.example.employeereactbackend.entity.Employee;
import org.springframework.beans.BeanUtils;

public class EntityUtil {
    public static Employee toEmployeeEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        return employee;

    }

    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        return employeeDto;
    }
}
