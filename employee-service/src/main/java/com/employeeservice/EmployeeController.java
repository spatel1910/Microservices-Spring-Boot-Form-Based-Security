package com.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee")
    public String getEmpName(){
        return "Sandeep kumar Patel";
    }

    @GetMapping("/nick")
    public String getNickName(){
        return "Avi";
    }
}
