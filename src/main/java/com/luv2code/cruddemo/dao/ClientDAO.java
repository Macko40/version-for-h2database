package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Client;

import java.util.List;

public interface ClientDAO {
    public void saveClient(Client theClient);

    public Client findClientById(Integer id);

    public List<Client> findAllClient();

    public List<Client> findClientByLastName(String lastName);

    public void updateClientFirstName(Client theClient);

    void deleteClient(Integer id);

    int deleteAll();
}
