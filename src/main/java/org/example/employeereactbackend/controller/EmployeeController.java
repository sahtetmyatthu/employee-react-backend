package org.example.employeereactbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.employeereactbackend.dto.EmployeeDto;
import org.example.employeereactbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@CrossOrigin()
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") int id){
        return  employeeService.getEmployeeById(id);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody  EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping("/{id}")

    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto,
                                      @PathVariable("id") int id){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}