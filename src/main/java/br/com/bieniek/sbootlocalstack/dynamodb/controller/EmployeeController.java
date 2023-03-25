package br.com.bieniek.sbootlocalstack.dynamodb.controller;

import br.com.bieniek.sbootlocalstack.dynamodb.entity.Employee;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
public interface EmployeeController {


    @PostMapping
    Employee save(@RequestBody Employee employee) ;

    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable("id") String employeeId);

    @DeleteMapping("/{id}")
    String deleteEmployeeById(@PathVariable("id") String employeeId);

    @PutMapping("/{id}")
    public String updateEmployeeById(@PathVariable("id") String employeeId, @RequestBody Employee employee);
}
