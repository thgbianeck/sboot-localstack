package br.com.bieniek.sbootlocalstack.dynamodb.repository.impl;

import br.com.bieniek.sbootlocalstack.dynamodb.entity.Employee;
import br.com.bieniek.sbootlocalstack.dynamodb.repository.EmployeeRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final DynamoDBMapper dynamoDBMapper;
    @Override
    public Employee save(Employee employee) {
        dynamoDBMapper.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return dynamoDBMapper.load(Employee.class, employeeId);
    }

    @Override
    public String deleteEmployeeById(String employeeId) {
        Employee employee = getEmployeeById(employeeId);
        if (employee != null) {
            dynamoDBMapper.delete(employee);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }

    @Override
    public String updateEmployeeById(String employeeId, Employee employee) {
        Employee empl = getEmployeeById(employeeId);
        if (empl != null) {
            dynamoDBMapper.save(empl, new DynamoDBSaveExpression()
                    .withExpectedEntry("employeeId",
                            new ExpectedAttributeValue(
                                    new AttributeValue().withS(employeeId)
                            )
                    )
            );
            return "Employee " + employeeId + " updated successfully";
        }
        return "Employee " + employeeId +" not found";
    }
}
