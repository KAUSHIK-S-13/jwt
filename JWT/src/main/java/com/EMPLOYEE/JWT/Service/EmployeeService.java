package com.EMPLOYEE.JWT.Service;

import com.EMPLOYEE.JWT.BaseResponse.BaseResponse;
import com.EMPLOYEE.JWT.DTO.EmployeeDTO;
import com.EMPLOYEE.JWT.DTO.TokenDto;
import com.EMPLOYEE.JWT.Model.Employee;
import com.EMPLOYEE.JWT.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.EMPLOYEE.JWT.Util.GenrateToken.generateToken;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public BaseResponse addetail(EmployeeDTO employeeDTO)
    {
        Employee dto=new Employee();
        BaseResponse baseResponse=new BaseResponse();
        dto.setEmpName(employeeDTO.getEmpName());
        dto.setEmail(employeeDTO.getEmail());
        dto.setPassword(employeeDTO.getPassword());
        employeeRepository.save(dto);
        baseResponse.setData(dto);
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("sucess");
        return  baseResponse;
    }


    public BaseResponse jwt(TokenDto tokenDto) {
        Optional<Employee> empl = employeeRepository.findByEmail(tokenDto.getEmail());
        try {
            if (empl.isPresent()) {
                String jwtt = generateToken(empl.get().getEmail(),"üser",empl.get().getPassword());
                tokenDto.setToken(jwtt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("sucess");
        baseResponse.setData(tokenDto);
        return  baseResponse;
    }
}
