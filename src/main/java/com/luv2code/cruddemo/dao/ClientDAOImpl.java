package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientDAOImpl implements ClientDAO{
    // define field for entityManager
    private EntityManager entityManager;

    // inject entityManager using constructor injection
    @Autowired
    public ClientDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implements saveClient method
    @Override
    @Transactional
    public void saveClient(Client theClient) {
        entityManager.persist(theClient);
    }

    @Override
    public Client findClientById(Integer id) {
        return entityManager.find(Client.class,id);
    }

    @Override
    public List<Client> findAllClient() {
        // create a query
        TypedQuery <Client> theQuery = entityManager.createQuery("from Client order by lastName", Client.class);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Client> findClientByLastName(String theLastName) {
        // create a query
        TypedQuery <Client> queryFindLastName = entityManager.createQuery("from Client where lastName=:theData", Client.class);
        // set query parameters
        queryFindLastName.setParameter("theData", theLastName);

        // return results
        return queryFindLastName.getResultList();
    }

    @Override
    @Transactional
    public void updateClientFirstName(Client theClient) {
        entityManager.merge(theClient);
    }

    @Override
    @Transactional
    public void deleteClient(Integer id) {
        // retrieve the Client

        Client theClient = entityManager.find(Client.class, id);

        // Delete the Client
        entityManager.remove(theClient);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("delete from Client").executeUpdate();
        return numRowsDeleted;
    }
}
