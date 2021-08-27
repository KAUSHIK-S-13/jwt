package com.EMPLOYEE.JWT.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {
    private int empId;
    private String empName;
    private String email;
    private String password;
}
