package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

  // define field for entityManager
  private EntityManager entityManager;

  // inject entityManager using constructor injection
  @Autowired
  public EmployeeDAOImpl(EntityManager theEntityManager) {
    this.entityManager = theEntityManager;
  }


  @Override
  public List<Employee> findAllEmployee() {
    // create a query
    TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

    // execute query and get result list
    List<Employee> employees = theQuery.getResultList();

    // return query results
    return employees;
  }

  @Override
  public Employee findEmployeeById(int theId) {

    // get theEmployee
    Employee theEmployee = entityManager.find(Employee.class, theId);
    // return theEmployee
    return theEmployee;
  }


  // implements saveClient method
  @Override
  public Employee saveEmployee(Employee theEmployee) {
    // save or update the employee
    Employee dbEmployee = entityManager.merge(theEmployee);

    // return  the dbEmployee
    return dbEmployee;
  }

  @Override
  public void deleteEmployeeById(int theId) {
    // find employee by id
    Employee theEmployee = entityManager.find(Employee.class, theId);

    // remove employee
    entityManager.remove(theEmployee);
  }

  @Override
  public List<Employee> findEmployeeByLastName(String theLastName) {
    // create a query
    TypedQuery<Employee> queryFindLastName = entityManager.createQuery(
        "FROM Employee where lastName=:theData", Employee.class);
    // set query parameters
    queryFindLastName.setParameter("theData", theLastName);

    // return results
    return queryFindLastName.getResultList();
  }

  @Override
  public void updateEmployeeFirstName(Employee theEmployee) {
    entityManager.merge(theEmployee);
  }


  @Override
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("delete from Employee").executeUpdate();
    return numRowsDeleted;
  }
}
