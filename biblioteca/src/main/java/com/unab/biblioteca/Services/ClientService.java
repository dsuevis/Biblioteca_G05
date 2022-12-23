package com.unab.biblioteca.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.biblioteca.Models.Client;
import com.unab.biblioteca.Repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired 
    private  ClientRepository  clientRepository;

    //Traer todos los clientes
   public List<Client> getAllClient(){
    return clientRepository.getAll();
   }

    //Traer una por id
    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    // Guardar
    public Client insertClient(Client client) {
        if (client.getIdClient() == null)
            // Campos obligatorios
            if (client.getClientname() != null && client.getClientlastname() != null && client.getTelephone() != null)
                return clientRepository.save(client);
            else
                return client;
        else
            return client;
    }

    // Actualizar
    public Client updateClient (Client client) {
        if (client.getIdClient() != null) {
            // verificación de que el id exista en base de datos
            Optional<Client> temp = clientRepository.getClient(client.getIdClient());
            if (!temp.isEmpty()) {
                if (client.getClientname() != null)
                    temp.get().setClientname(client.getClientname());
                if (client.getClientlastname() != null)
                    temp.get().setClientlastname(client.getClientlastname());
                if (client.getAddress() != null)
                    temp.get().setAddress(client.getAddress());
                if (client.getEmail() != null)
                    temp.get().setEmail(client.getEmail());
                if (client.getTelephone() != null)
                    temp.get().setTelephone(client.getTelephone());
                return clientRepository.save(temp.get());
            } else
                return client;
        } else
            return client;
    }

    // Eliminar
    public boolean deleteClient(int IdClient) {
        Boolean success = getClient(IdClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return success;
    }

    
}
