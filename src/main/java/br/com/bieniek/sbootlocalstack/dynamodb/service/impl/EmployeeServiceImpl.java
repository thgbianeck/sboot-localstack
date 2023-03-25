package br.com.bieniek.sbootlocalstack.dynamodb.service.impl;

import br.com.bieniek.sbootlocalstack.dynamodb.entity.Employee;
import br.com.bieniek.sbootlocalstack.dynamodb.repository.EmployeeRepository;
import br.com.bieniek.sbootlocalstack.dynamodb.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Override
    public String deleteEmployeeById(String employeeId) {
        return employeeRepository.deleteEmployeeById(employeeId);
    }

    @Override
    public String updateEmployeeById(String employeeId, Employee employee) {
        return employeeRepository.updateEmployeeById(employeeId, employee);
    }
}
