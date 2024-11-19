package org.example.employeereactbackend.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.employeereactbackend.dao.EmployeeDao;
import org.example.employeereactbackend.dto.EmployeeDto;
import org.example.employeereactbackend.entity.Employee;
import org.example.employeereactbackend.utils.EntityUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public List<EmployeeDto> getAllEmployees() {
        return employeeDao.findAll()
                .stream()
                .map(EntityUtil::toEmployeeDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public EmployeeDto getEmployeeById(int id) {
        return employeeDao.findById(id)
                .map(EntityUtil::toEmployeeDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return EntityUtil.toEmployeeDto(employeeDao
                .save(EntityUtil.toEmployeeEntity(employeeDto)));
    }

    @Transactional
    public EmployeeDto updateEmployee(int id, EmployeeDto employeeDto) {
        if (employeeDao.existsById(id)) {
            Employee employee = EntityUtil.toEmployeeEntity(employeeDto);
            employee.setId(id);
            return EntityUtil.toEmployeeDto(employeeDao.save(employee));
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    public void deleteEmployee(int id) {
        if (employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
