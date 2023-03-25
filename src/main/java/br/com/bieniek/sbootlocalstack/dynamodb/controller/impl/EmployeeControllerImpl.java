package br.com.bieniek.sbootlocalstack.dynamodb.controller.impl;

import br.com.bieniek.sbootlocalstack.dynamodb.controller.EmployeeController;
import br.com.bieniek.sbootlocalstack.dynamodb.entity.Employee;
import br.com.bieniek.sbootlocalstack.dynamodb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeControllerImpl implements EmployeeController {

    private final EmployeeService employeeService;

    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    public Employee getEmployeeById(@PathVariable("id") String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    public String deleteEmployeeById(@PathVariable("id") String employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

    public String updateEmployeeById(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(employeeId, employee);
    }
}
