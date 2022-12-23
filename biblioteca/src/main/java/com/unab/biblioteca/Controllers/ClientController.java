package com.unab.biblioteca.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unab.biblioteca.Models.Client;
import com.unab.biblioteca.Services.ClientService;

@RestController 
@RequestMapping ("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //Traer todos los clientes
    @GetMapping("/all")
    public List<Client> getAllClient(){
     return clientService.getAllClient();
   }

    //Traer una por id
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient){
        return clientService.getClient(idClient);
    }

    //Guardar
    @PostMapping ("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient (@RequestBody Client client){
            return clientService.insertClient(client);
        }

    //Actualizar
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient (@RequestBody Client client) {
        return clientService.updateClient(client);
    }

    //Eliminar
    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient(@PathVariable ("id") int idClient){
        return clientService.deleteClient(idClient);
    }
}
