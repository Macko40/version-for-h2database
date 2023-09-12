package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import java.util.Optional;
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
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
		return runner ->{
			//createEmployee(employeeRepository);

			//createMultipleClients(employeeRepository);

			//readClient(employeeRepository);

			//queryForClient(employeeRepository);

			//queryForClientByLastName(employeeRepository);

			//updateClientFirstName(employeeRepository);

			//deleteClient(employeeRepository);

			//deleteAllClients(employeeRepository);
		};
	}

	private void deleteAllClients(EmployeeRepository employeeRepository) {
		System.out.println("Deleting all Clients");
		//int numRowsDeleted = employeeRepository.deleteAll();
		//System.out.println("Number of deleted Clients: " + numRowsDeleted );
	}

	private void deleteClient(EmployeeRepository employeeRepository) {

		// Retrieve Client base on Id: primary key
		int employeetId = 1;
		System.out.println("Deleting Client id: " + employeetId);

		// deleting Client
		System.out.println("Deleting Client...");
		employeeRepository.deleteById(employeetId);

	}

	private void updateClientFirstName(EmployeeRepository employeeRepository) {
		// Retrieve Client based on the Id: primary key
		int clientId = 203;
		System.out.println("Getting Client id: " + clientId);

		Optional<Employee> theEmployee = employeeRepository.findById(clientId);


		// Change first Name to "John"
		System.out.println("Updating Clients...");
		//theEmployee("John");

		// Updating Client
		//employeeRepository.updateEmployeeFirstName(theEmployee);

		// display updating Client
		System.out.println("Updated Client: " + theEmployee);

	}

	private void queryForClientByLastName(EmployeeRepository employeeRepository) {
		// get a List
		//List<Employee> theClientsLastName = employeeRepository.findEmployeeByLastName("Perez");

		// display list of Clients
		//for(Employee tempEmployee : theClientsLastName){
			//System.out.println(tempEmployee);
		}

	private void queryForClient(EmployeeRepository employeeRepository) {
		// get a  list of Clients
		List<Employee> theEmployees = employeeRepository.findAll();

		// display list of Clients
		for(Employee tempEmployee : theEmployees){
			System.out.println(tempEmployee);
		}

	}

	private void readClient(EmployeeRepository employeeRepository) {
		//create a new Client
		System.out.println("Creating a new Client...");
		Employee tempEmployee = new Employee("Refael", "Rahavi", "rahavia@gmail.com");

		//save the Client
		System.out.println("Saving the Clients");
		employeeRepository.save(tempEmployee);

		//display id form saved Client
		int theId = tempEmployee.getId();
		System.out.println("Saved Client.Generated id: " + theId);

		//Retrieve/Read Client base on id primary key
		System.out.println("Retrieving Client with id: " + theId);
		Optional<Employee> myEmployee = employeeRepository.findById(theId);

		// Display Client
		System.out.println("Found the Client: " + myEmployee);

	}

	private void createMultipleClients(EmployeeRepository employeeRepository) {
		// creating 5 Employee Objects
		System.out.println("Creating 5 new Employee...");
		Employee tempEmployee1 = new Employee("Leslie", "Andrews", "leslie@email.com");
		Employee tempEmployee2 = new Employee("Emma", "Baumgarten", "emma@email.com");
		Employee tempEmployee3 = new Employee("Avani", "Gupta", "Gupta@email.com");
		Employee tempEmployee4 = new Employee("Yuri", "Petrov", "yuri@email.com");
		Employee tempEmployee5 = new Employee("Juan", "Vega", "juan@email.com");

		// save the Client Objects
		System.out.println("Saving the Employee");
		employeeRepository.save(tempEmployee1);
		employeeRepository.save(tempEmployee2);
		employeeRepository.save(tempEmployee3);
		employeeRepository.save(tempEmployee4);
		employeeRepository.save(tempEmployee5);
	}

	private void createEmployee(EmployeeRepository employeeRepository){

		// creating a new Employee Object
		System.out.println("Creating a new Employee...");
		Employee tempEmployee = new Employee("Maria", "Perez", "mariap@email.com");

		// save the Employee Object
		System.out.println("Saving the Employee...");
		employeeRepository.save(tempEmployee);

		// Display id from the saving Employee
		System.out.println("Saved Employee. Generated id " + tempEmployee.getId());


	}

}
