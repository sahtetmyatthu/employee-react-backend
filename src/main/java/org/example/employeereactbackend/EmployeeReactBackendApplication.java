package org.example.employeereactbackend;

import lombok.RequiredArgsConstructor;
import org.example.employeereactbackend.dao.EmployeeDao;
import org.example.employeereactbackend.entity.Employee;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeReactBackendApplication {
    private final EmployeeDao employeeDao;
    @Bean
    @Transactional
    @Profile("dev")
    public ApplicationRunner runner(){
        return args -> {
            List.of(
                    new Employee("John", "Doe","john@gmail.com","55-555-55"),
                    new Employee("John", "William","william@gmail.com","55-555-56"),
                    new Employee("John", "Updike","updike@gmail.com","55-555-57"),
                    new Employee("Charles", "Dickens","charles@gmail.com","55-555-58"),
                    new Employee("Thomas", "Hardy","thomas@gmail.com","55-555-59")
            ).forEach(employeeDao::save);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeReactBackendApplication.class, args);
    }

}
