package com.quinbay.employee.service;

import com.quinbay.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class EmpDetails {
    public static ArrayList<Employee> employee= new ArrayList<>();
    public Employee addEmployee(Employee inputEmployee){
        employee.add(inputEmployee);
        return inputEmployee;
    }

}
