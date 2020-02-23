package com.shikhar.crud.springbootcrudapi.controller;

import com.shikhar.crud.springbootcrudapi.model.Employee;
import com.shikhar.crud.springbootcrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> get() {
        return employeeService.get();
    }

    @PostMapping("/save_employee")
    public Employee save(@RequestBody Employee employeeObj){
        employeeService.save(employeeObj);
        return employeeObj;
    }

    @GetMapping("/employee/{id}")
    public Employee get(@PathVariable int id){
        Employee employeeObj = employeeService.get(id);
        if(employeeObj == null){
            throw new RuntimeException("Employee with id" + id + " is not found");
        }
        return employeeObj;
    }

    @DeleteMapping("delete_employee/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Employee has been deleted with id:"+id;
    }

    @PutMapping("/update_employee")
    public Employee update(@RequestBody Employee employeeObj){
        employeeService.save(employeeObj);
        return employeeObj;
    }
}
