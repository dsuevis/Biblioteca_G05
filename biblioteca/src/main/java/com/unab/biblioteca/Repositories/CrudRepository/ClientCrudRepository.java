package com.unab.biblioteca.Repositories.CrudRepository;

import org.springframework.data.repository.CrudRepository;
import com.unab.biblioteca.Models.Client;


public interface ClientCrudRepository extends CrudRepository <Client, Integer> {
    
}
