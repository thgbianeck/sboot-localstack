package br.com.bieniek.sbootlocalstack.dynamodb.service;

import br.com.bieniek.sbootlocalstack.dynamodb.entity.Employee;

public interface EmployeeService {

    Employee save(Employee employee);
    Employee getEmployeeById(String employeeId);
    String deleteEmployeeById(String employeeId);
    String updateEmployeeById(String employeeId, Employee employee);
}
