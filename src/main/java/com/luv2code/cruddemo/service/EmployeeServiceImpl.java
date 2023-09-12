package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // define Field employeeDAO
  private EmployeeRepository employeeRepository;

  // set up constructor injection
  public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
    this.employeeRepository = theEmployeeRepository;
  }

  // Inject EmployeeDAO
  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findEmployeeById(int theId) {
    Optional<Employee> result = employeeRepository.findById(theId);
    Employee theEmployee = null;

    if(result.isPresent()){
      theEmployee = result.get();
    } else{
      // we didn´t find the employee
      throw new RuntimeException("did not find employee id - " + theId);
    }
    return theEmployee;
  }


  @Override
  public Employee saveEmployee(Employee theEmployee) {
    return employeeRepository.save(theEmployee);
  }


  @Override
  public void deleteEmployeeById(int theId) {
    employeeRepository.deleteById(theId);
  }
}
