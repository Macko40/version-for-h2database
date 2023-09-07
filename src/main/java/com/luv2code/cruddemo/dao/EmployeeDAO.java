package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {


    public List<Employee> findAllEmployee();

    public Employee findEmployeeById(int theId);

    public Employee saveEmployee(Employee theEmployee);

    public void deleteEmployeeById(int theId);


    public List<Employee> findEmployeeByLastName(String lastName);

    public void updateEmployeeFirstName(Employee theEmployee);



    int deleteAll();
}
