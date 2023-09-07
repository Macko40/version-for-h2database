package com.luv2code.cruddemo.service;


import com.luv2code.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeService {

  public List<Employee> findAll();

  public Employee findEmployeeById(int theId);

  public Employee saveEmployee(Employee theEmployee);

  public void deleteEmployeeById(int theId);
}
