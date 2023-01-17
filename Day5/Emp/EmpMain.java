package com.quinbay.employee.controller;

import com.quinbay.employee.model.Employee;
import com.quinbay.employee.service.EmpDetails;
import com.quinbay.employee.web.EmpClientAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpMain {
    @Autowired
    EmpClientAPI empClientAPI;
    @Autowired
    EmpDetails employee;

    @GetMapping("/employee/{employeeId}")
    public String getRating(@PathVariable int employeeId){
        return empClientAPI.getRating(employeeId);
    }

    @PostMapping("/addEmployee")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee inputEmployee){
        return employee.addEmployee(inputEmployee);
    }

}
