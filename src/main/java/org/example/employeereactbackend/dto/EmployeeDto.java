package org.example.employeereactbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EmployeeDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;


}
