package com.EMPLOYEE.JWT.Controller;

import org.apache.commons.codec.binary.Base64;
import com.EMPLOYEE.JWT.BaseResponse.BaseResponse;
import com.EMPLOYEE.JWT.DTO.EmployeeDTO;
import com.EMPLOYEE.JWT.DTO.TokenDto;
import com.EMPLOYEE.JWT.Service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

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

    @PostMapping("/jwtdecode")
    public String decode(@RequestBody String token) throws UnsupportedEncodingException{

        String payload=token.split("\\.")[1];
        return new String(Base64.decodeBase64(payload),"UTF-8");
    }
}
