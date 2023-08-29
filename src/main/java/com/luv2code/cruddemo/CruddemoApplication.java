package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.ClientDAO;
import com.luv2code.cruddemo.entity.Client;
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
	public CommandLineRunner commandLineRunner(ClientDAO clientDAO){
		return runner ->{
			//createClient(clientDAO);

			createMultipleClients(clientDAO);

			//readClient(clientDAO);

			//queryForClient(clientDAO);

			//queryForClientByLastName(clientDAO);

			//updateClientFirstName(clientDAO);

			//deleteClient(clientDAO);

			//deleteAllClients(clientDAO);
		};
	}

	private void deleteAllClients(ClientDAO clientDAO) {
		System.out.println("Deleting all Clients");
		int numRowsDeleted = clientDAO.deleteAll();
		System.out.println("Number of deleted Clients: " + numRowsDeleted );
	}

	private void deleteClient(ClientDAO clientDAO) {

		// Retrieve Client base on Id: primary key
		int clientId = 202;
		System.out.println("Deleting Client id: " + clientId);

		// deleting Client
		System.out.println("Deleting Client...");
		clientDAO.deleteClient(clientId);

	}

	private void updateClientFirstName(ClientDAO clientDAO) {
		// Retrieve Client based on the Id: primary key
		int clientId = 203;
		System.out.println("Getting Client id: " + clientId);

		Client theClient = clientDAO.findClientById(clientId);

		// Change first Name to "John"
		System.out.println("Updating Clients...");
		theClient.setFirstName("John");

		// Updating Client
		clientDAO.updateClientFirstName(theClient);

		// display updating Client
		System.out.println("Updated Client: " + theClient);

	}

	private void queryForClientByLastName(ClientDAO clientDAO) {
		// get a List
		List<Client> theClientsLastName = clientDAO.findClientByLastName("Perez");

		// display list of Clients
		for(Client tempClient : theClientsLastName){
			System.out.println(tempClient);
		}
	}

	private void queryForClient(ClientDAO clientDAO) {
		// get a  list of Clients
		List<Client> theClients = clientDAO.findAllClient();

		// display list of Clients
		for(Client tempClient : theClients){
			System.out.println(tempClient);
		}

	}

	private void readClient(ClientDAO clientDAO) {
		//create a new Client
		System.out.println("Creating a new Client...");
		Client tempClient = new Client("Refael", "Rahavi", "rahavia@gmail.com");

		//save the Client
		System.out.println("Saving the Clients");
		clientDAO.saveClient(tempClient);

		//display id form saved Client
		int theId = tempClient.getId();
		System.out.println("Saved Client.Generated id: " + theId);

		//Retrieve/Read Client base on id primary key
		System.out.println("Retrieving Client with id: " + theId);
		Client myClient = clientDAO.findClientById(theId);

		// Display Client
		System.out.println("Found the Client: " + myClient);

	}

	private void createMultipleClients(ClientDAO clientDAO) {
		// creating 3 Clients Objects
		System.out.println("Creating 3 new Clients...");
		Client tempClient1 = new Client("Joan", "Perez", "joanp@email.com");
		Client tempClient2 = new Client("Carlos", "Martinez", "carlosma@email.com");
		Client tempClient3 = new Client("Sofia", "Pena", "sofiapena@email.com");

		// save the Client Objects
		System.out.println("Saving the Clients");
		clientDAO.saveClient(tempClient1);
		clientDAO.saveClient(tempClient2);
		clientDAO.saveClient(tempClient3);
	}

	private void createClient(ClientDAO clientDAO){

		// creating a new Client Object
		System.out.println("Creating a new Client...");
		Client tempClient = new Client("Maria", "Perez", "mariap@email.com");

		// save the Client Object
		System.out.println("Saving the Client...");
		clientDAO.saveClient(tempClient);

		// Display id from the saving Client
		System.out.println("Saved Client. Generated id " + tempClient.getId());


	}

}
