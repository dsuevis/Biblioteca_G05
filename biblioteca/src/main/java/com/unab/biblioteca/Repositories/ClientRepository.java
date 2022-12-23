package com.unab.biblioteca.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unab.biblioteca.Models.Client;
import com.unab.biblioteca.Repositories.CrudRepository.ClientCrudRepository;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    //Función para traer todos los clientes
    /**
     * @return
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();     
    }

    //Función para buscar por código
    public Optional<Client> getClient (int idCliente){
        return clientCrudRepository.findById(idCliente);
    }
    //Función para guardar 
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }

    //Función para eliminar
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
    
}
