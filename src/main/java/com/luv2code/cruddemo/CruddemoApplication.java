package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO){
		return runner ->{
			//createEmployee(employeeDAO);

			//createMultipleClients(employeeDAO);

			//readClient(employeeDAO);

			//queryForClient(employeeDAO);

			//queryForClientByLastName(employeeDAO);

			//updateClientFirstName(employeeDAO);

			//deleteClient(employeeDAO);

			//deleteAllClients(employeeDAO);
		};
	}

	private void deleteAllClients(EmployeeDAO employeeDAO) {
		System.out.println("Deleting all Clients");
		int numRowsDeleted = employeeDAO.deleteAll();
		System.out.println("Number of deleted Clients: " + numRowsDeleted );
	}

	private void deleteClient(EmployeeDAO employeeDAO) {

		// Retrieve Client base on Id: primary key
		int employeetId = 1;
		System.out.println("Deleting Client id: " + employeetId);

		// deleting Client
		System.out.println("Deleting Client...");
		employeeDAO.deleteEmployeeById(employeetId);

	}

	private void updateClientFirstName(EmployeeDAO employeeDAO) {
		// Retrieve Client based on the Id: primary key
		int clientId = 203;
		System.out.println("Getting Client id: " + clientId);

		Employee theEmployee = employeeDAO.findEmployeeById(clientId);

		// Change first Name to "John"
		System.out.println("Updating Clients...");
		theEmployee.setFirstName("John");

		// Updating Client
		employeeDAO.updateEmployeeFirstName(theEmployee);

		// display updating Client
		System.out.println("Updated Client: " + theEmployee);

	}

	private void queryForClientByLastName(EmployeeDAO employeeDAO) {
		// get a List
		List<Employee> theClientsLastName = employeeDAO.findEmployeeByLastName("Perez");

		// display list of Clients
		for(Employee tempEmployee : theClientsLastName){
			System.out.println(tempEmployee);
		}
	}

	private void queryForClient(EmployeeDAO employeeDAO) {
		// get a  list of Clients
		List<Employee> theEmployees = employeeDAO.findAllEmployee();

		// display list of Clients
		for(Employee tempEmployee : theEmployees){
			System.out.println(tempEmployee);
		}

	}

	private void readClient(EmployeeDAO employeeDAO) {
		//create a new Client
		System.out.println("Creating a new Client...");
		Employee tempEmployee = new Employee("Refael", "Rahavi", "rahavia@gmail.com");

		//save the Client
		System.out.println("Saving the Clients");
		employeeDAO.saveEmployee(tempEmployee);

		//display id form saved Client
		int theId = tempEmployee.getId();
		System.out.println("Saved Client.Generated id: " + theId);

		//Retrieve/Read Client base on id primary key
		System.out.println("Retrieving Client with id: " + theId);
		Employee myEmployee = employeeDAO.findEmployeeById(theId);

		// Display Client
		System.out.println("Found the Client: " + myEmployee);

	}

	private void createMultipleClients(EmployeeDAO employeeDAO) {
		// creating 5 Employee Objects
		System.out.println("Creating 5 new Employee...");
		Employee tempEmployee1 = new Employee("Leslie", "Andrews", "leslie@email.com");
		Employee tempEmployee2 = new Employee("Emma", "Baumgarten", "emma@email.com");
		Employee tempEmployee3 = new Employee("Avani", "Gupta", "Gupta@email.com");
		Employee tempEmployee4 = new Employee("Yuri", "Petrov", "yuri@email.com");
		Employee tempEmployee5 = new Employee("Juan", "Vega", "juan@email.com");

		// save the Client Objects
		System.out.println("Saving the Employee");
		employeeDAO.saveEmployee(tempEmployee1);
		employeeDAO.saveEmployee(tempEmployee2);
		employeeDAO.saveEmployee(tempEmployee3);
		employeeDAO.saveEmployee(tempEmployee4);
		employeeDAO.saveEmployee(tempEmployee5);
	}

	private void createEmployee(EmployeeDAO employeeDAO){

		// creating a new Employee Object
		System.out.println("Creating a new Employee...");
		Employee tempEmployee = new Employee("Maria", "Perez", "mariap@email.com");

		// save the Employee Object
		System.out.println("Saving the Employee...");
		employeeDAO.saveEmployee(tempEmployee);

		// Display id from the saving Employee
		System.out.println("Saved Employee. Generated id " + tempEmployee.getId());


	}

}
