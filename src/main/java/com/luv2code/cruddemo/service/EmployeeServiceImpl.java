package com.luv2code.cruddemo.service;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  // define Field employeeDAO
  private EmployeeDAO employeeDAO;

  // set up constructor injection
  public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  // Inject EmployeeDAO
  @Override
  public List<Employee> findAll() {
    return employeeDAO.findAllEmployee();
  }

  @Override
  public Employee findEmployeeById(int theId) {
    return employeeDAO.findEmployeeById(theId);
  }

  @Transactional
  @Override
  public Employee saveEmployee(Employee theEmployee) {
    return employeeDAO.saveEmployee(theEmployee);
  }

  @Transactional
  @Override
  public void deleteEmployeeById(int theId) {
    employeeDAO.deleteEmployeeById(theId);
  }
}
