package com.EMPLOYEE.JWT.Controller;


import com.EMPLOYEE.JWT.BaseResponse.BaseResponse;
import com.EMPLOYEE.JWT.DTO.EmployeeDTO;
import com.EMPLOYEE.JWT.DTO.TokenDto;
import com.EMPLOYEE.JWT.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService obj;

    @PostMapping("/addemployee")
    public BaseResponse addetail(@RequestBody EmployeeDTO employeeDTO)
    {
        return obj.addetail(employeeDTO);
    }
    @GetMapping("/login")
    public BaseResponse jwt(@RequestBody TokenDto tokenDto) {
        return obj.jwt(tokenDto);
    }
}
